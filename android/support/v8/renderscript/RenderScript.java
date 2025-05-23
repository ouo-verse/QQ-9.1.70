package android.support.v8.renderscript;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemProperties;
import android.renderscript.RenderScript;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
public class RenderScript {
    private static final String CACHE_PATH = "com.android.renderscript.cache";
    static final boolean DEBUG = false;
    static final boolean LOG_ENABLED = false;
    static final String LOG_TAG = "RenderScript_jni";
    static boolean isNative = false;
    static Object lock = new Object();
    static String mCachePath;
    static Method registerNativeAllocation;
    static Method registerNativeFree;
    static boolean sInitialized;
    static Object sRuntime;
    static boolean sUseGCHooks;
    private static int thunk;
    private Context mApplicationContext;
    int mContext;
    int mDev;
    Element mElement_ALLOCATION;
    Element mElement_A_8;
    Element mElement_BOOLEAN;
    Element mElement_CHAR_2;
    Element mElement_CHAR_3;
    Element mElement_CHAR_4;
    Element mElement_DOUBLE_2;
    Element mElement_DOUBLE_3;
    Element mElement_DOUBLE_4;
    Element mElement_ELEMENT;
    Element mElement_F32;
    Element mElement_F64;
    Element mElement_FLOAT_2;
    Element mElement_FLOAT_3;
    Element mElement_FLOAT_4;
    Element mElement_I16;
    Element mElement_I32;
    Element mElement_I64;
    Element mElement_I8;
    Element mElement_INT_2;
    Element mElement_INT_3;
    Element mElement_INT_4;
    Element mElement_LONG_2;
    Element mElement_LONG_3;
    Element mElement_LONG_4;
    Element mElement_MATRIX_2X2;
    Element mElement_MATRIX_3X3;
    Element mElement_MATRIX_4X4;
    Element mElement_RGBA_4444;
    Element mElement_RGBA_5551;
    Element mElement_RGBA_8888;
    Element mElement_RGB_565;
    Element mElement_RGB_888;
    Element mElement_SAMPLER;
    Element mElement_SCRIPT;
    Element mElement_SHORT_2;
    Element mElement_SHORT_3;
    Element mElement_SHORT_4;
    Element mElement_TYPE;
    Element mElement_U16;
    Element mElement_U32;
    Element mElement_U64;
    Element mElement_U8;
    Element mElement_UCHAR_2;
    Element mElement_UCHAR_3;
    Element mElement_UCHAR_4;
    Element mElement_UINT_2;
    Element mElement_UINT_3;
    Element mElement_UINT_4;
    Element mElement_ULONG_2;
    Element mElement_ULONG_3;
    Element mElement_ULONG_4;
    Element mElement_USHORT_2;
    Element mElement_USHORT_3;
    Element mElement_USHORT_4;
    MessageThread mMessageThread;
    Sampler mSampler_CLAMP_LINEAR;
    Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
    Sampler mSampler_CLAMP_NEAREST;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_NEAREST;
    Sampler mSampler_WRAP_LINEAR;
    Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
    Sampler mSampler_WRAP_NEAREST;
    RSMessageHandler mMessageCallback = null;
    RSErrorHandler mErrorCallback = null;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum ContextType {
        NORMAL(0),
        DEBUG(1),
        PROFILE(2);

        int mID;

        ContextType(int i3) {
            this.mID = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class MessageThread extends BaseThread {
        static final int RS_ERROR_FATAL_UNKNOWN = 4096;
        static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
        static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
        static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
        static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
        static final int RS_MESSAGE_TO_CLIENT_USER = 4;
        int[] mAuxData;
        RenderScript mRS;
        boolean mRun;

        MessageThread(RenderScript renderScript) {
            super("RSMessageThread");
            this.mRun = true;
            this.mAuxData = new int[2];
            this.mRS = renderScript;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            int[] iArr = new int[16];
            RenderScript renderScript = this.mRS;
            renderScript.nContextInitToClient(renderScript.mContext);
            while (this.mRun) {
                iArr[0] = 0;
                RenderScript renderScript2 = this.mRS;
                int nContextPeekMessage = renderScript2.nContextPeekMessage(renderScript2.mContext, this.mAuxData);
                int[] iArr2 = this.mAuxData;
                int i3 = iArr2[1];
                int i16 = iArr2[0];
                if (nContextPeekMessage == 4) {
                    if ((i3 >> 2) >= iArr.length) {
                        iArr = new int[(i3 + 3) >> 2];
                    }
                    RenderScript renderScript3 = this.mRS;
                    if (renderScript3.nContextGetUserMessage(renderScript3.mContext, iArr) == 4) {
                        RSMessageHandler rSMessageHandler = this.mRS.mMessageCallback;
                        if (rSMessageHandler != null) {
                            rSMessageHandler.mData = iArr;
                            rSMessageHandler.mID = i16;
                            rSMessageHandler.mLength = i3;
                            rSMessageHandler.run();
                        } else {
                            throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                        }
                    } else {
                        throw new RSDriverException("Error processing message from RenderScript.");
                    }
                } else if (nContextPeekMessage == 3) {
                    RenderScript renderScript4 = this.mRS;
                    String nContextGetErrorMessage = renderScript4.nContextGetErrorMessage(renderScript4.mContext);
                    if (i16 < 4096) {
                        RSErrorHandler rSErrorHandler = this.mRS.mErrorCallback;
                        if (rSErrorHandler != null) {
                            rSErrorHandler.mErrorMessage = nContextGetErrorMessage;
                            rSErrorHandler.mErrorNum = i16;
                            rSErrorHandler.run();
                        } else {
                            Log.e(RenderScript.LOG_TAG, "non fatal RS error, " + nContextGetErrorMessage);
                        }
                    } else {
                        throw new RSRuntimeException("Fatal error " + i16 + ", details: " + nContextGetErrorMessage);
                    }
                } else {
                    try {
                        Thread.sleep(1L, 0);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Priority {
        LOW(15),
        NORMAL(-4);

        int mID;

        Priority(int i3) {
            this.mID = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderScript(Context context) {
        if (context != null) {
            this.mApplicationContext = context.getApplicationContext();
        }
    }

    public static RenderScript create(Context context, int i3) {
        return create(context, i3, ContextType.NORMAL);
    }

    public static void setupDiskCache(File file) {
        File file2 = new File(file, CACHE_PATH);
        mCachePath = file2.getAbsolutePath();
        file2.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean shouldThunk() {
        if (thunk == 0) {
            if (SystemProperties.getInt("debug.rs.forcecompat", 0) == 0) {
                thunk = 1;
            } else {
                thunk = -1;
            }
        }
        if (thunk != 1) {
            return false;
        }
        return true;
    }

    public void contextDump() {
        validate();
        nContextDump(0);
    }

    public void destroy() {
        validate();
        nContextDeinitToClient(this.mContext);
        MessageThread messageThread = this.mMessageThread;
        messageThread.mRun = false;
        try {
            messageThread.join();
        } catch (InterruptedException unused) {
        }
        nContextDestroy();
        this.mContext = 0;
        nDeviceDestroy(this.mDev);
        this.mDev = 0;
    }

    public void finish() {
        nContextFinish();
    }

    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public RSErrorHandler getErrorHandler() {
        return this.mErrorCallback;
    }

    public RSMessageHandler getMessageHandler() {
        return this.mMessageCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAlive() {
        if (this.mContext != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationCopyFromBitmap(int i3, Bitmap bitmap) {
        validate();
        rsnAllocationCopyFromBitmap(this.mContext, i3, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationCopyToBitmap(int i3, Bitmap bitmap) {
        validate();
        rsnAllocationCopyToBitmap(this.mContext, i3, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nAllocationCreateBitmapBackedAllocation(int i3, int i16, Bitmap bitmap, int i17) {
        validate();
        return rsnAllocationCreateBitmapBackedAllocation(this.mContext, i3, i16, bitmap, i17);
    }

    synchronized int nAllocationCreateBitmapRef(int i3, Bitmap bitmap) {
        validate();
        return rsnAllocationCreateBitmapRef(this.mContext, i3, bitmap);
    }

    synchronized int nAllocationCreateFromAssetStream(int i3, int i16, int i17) {
        validate();
        return rsnAllocationCreateFromAssetStream(this.mContext, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nAllocationCreateFromBitmap(int i3, int i16, Bitmap bitmap, int i17) {
        validate();
        return rsnAllocationCreateFromBitmap(this.mContext, i3, i16, bitmap, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nAllocationCreateTyped(int i3, int i16, int i17, int i18) {
        validate();
        return rsnAllocationCreateTyped(this.mContext, i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nAllocationCubeCreateFromBitmap(int i3, int i16, Bitmap bitmap, int i17) {
        validate();
        return rsnAllocationCubeCreateFromBitmap(this.mContext, i3, i16, bitmap, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData1D(int i3, int i16, int i17, int i18, int[] iArr, int i19) {
        validate();
        rsnAllocationData1D(this.mContext, i3, i16, i17, i18, iArr, i19);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38) {
        validate();
        rsnAllocationData2D(this.mContext, i3, i16, i17, i18, i19, i26, i27, i28, i29, i36, i37, i38);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39) {
        validate();
        rsnAllocationData3D(this.mContext, i3, i16, i17, i18, i19, i26, i27, i28, i29, i36, i37, i38, i39);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationElementData1D(int i3, int i16, int i17, int i18, byte[] bArr, int i19) {
        validate();
        rsnAllocationElementData1D(this.mContext, i3, i16, i17, i18, bArr, i19);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationGenerateMipmaps(int i3) {
        validate();
        rsnAllocationGenerateMipmaps(this.mContext, i3);
    }

    synchronized int nAllocationGetType(int i3) {
        validate();
        return rsnAllocationGetType(this.mContext, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationIoReceive(int i3) {
        validate();
        rsnAllocationIoReceive(this.mContext, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationIoSend(int i3) {
        validate();
        rsnAllocationIoSend(this.mContext, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationRead(int i3, byte[] bArr) {
        validate();
        rsnAllocationRead(this.mContext, i3, bArr);
    }

    synchronized void nAllocationResize1D(int i3, int i16) {
        validate();
        rsnAllocationResize1D(this.mContext, i3, i16);
    }

    synchronized void nAllocationResize2D(int i3, int i16, int i17) {
        validate();
        rsnAllocationResize2D(this.mContext, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationSyncAll(int i3, int i16) {
        validate();
        rsnAllocationSyncAll(this.mContext, i3, i16);
    }

    synchronized int nContextCreate(int i3, int i16, int i17, int i18) {
        return rsnContextCreate(i3, i16, i17, i18);
    }

    native void nContextDeinitToClient(int i3);

    synchronized void nContextDestroy() {
        validate();
        rsnContextDestroy(this.mContext);
    }

    synchronized void nContextDump(int i3) {
        validate();
        rsnContextDump(this.mContext, i3);
    }

    synchronized void nContextFinish() {
        validate();
        rsnContextFinish(this.mContext);
    }

    native String nContextGetErrorMessage(int i3);

    native int nContextGetUserMessage(int i3, int[] iArr);

    native void nContextInitToClient(int i3);

    native int nContextPeekMessage(int i3, int[] iArr);

    synchronized void nContextSendMessage(int i3, int[] iArr) {
        validate();
        rsnContextSendMessage(this.mContext, i3, iArr);
    }

    synchronized void nContextSetPriority(int i3) {
        validate();
        rsnContextSetPriority(this.mContext, i3);
    }

    native int nDeviceCreate();

    native void nDeviceDestroy(int i3);

    native void nDeviceSetConfig(int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nElementCreate(int i3, int i16, boolean z16, int i17) {
        validate();
        return rsnElementCreate(this.mContext, i3, i16, z16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nElementCreate2(int[] iArr, String[] strArr, int[] iArr2) {
        validate();
        return rsnElementCreate2(this.mContext, iArr, strArr, iArr2);
    }

    synchronized void nElementGetNativeData(int i3, int[] iArr) {
        validate();
        rsnElementGetNativeData(this.mContext, i3, iArr);
    }

    synchronized void nElementGetSubElements(int i3, int[] iArr, String[] strArr, int[] iArr2) {
        validate();
        rsnElementGetSubElements(this.mContext, i3, iArr, strArr, iArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nObjDestroy(int i3) {
        int i16 = this.mContext;
        if (i16 != 0) {
            rsnObjDestroy(i16, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nSamplerCreate(int i3, int i16, int i17, int i18, int i19, float f16) {
        validate();
        return rsnSamplerCreate(this.mContext, i3, i16, i17, i18, i19, f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptBindAllocation(int i3, int i16, int i17) {
        validate();
        rsnScriptBindAllocation(this.mContext, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nScriptCCreate(String str, String str2, byte[] bArr, int i3) {
        validate();
        return rsnScriptCCreate(this.mContext, str, str2, bArr, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nScriptFieldIDCreate(int i3, int i16) {
        validate();
        return rsnScriptFieldIDCreate(this.mContext, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptForEach(int i3, int i16, int i17, int i18, byte[] bArr) {
        validate();
        if (bArr == null) {
            rsnScriptForEach(this.mContext, i3, i16, i17, i18);
        } else {
            rsnScriptForEach(this.mContext, i3, i16, i17, i18, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptForEachClipped(int i3, int i16, int i17, int i18, byte[] bArr, int i19, int i26, int i27, int i28, int i29, int i36) {
        validate();
        if (bArr == null) {
            rsnScriptForEachClipped(this.mContext, i3, i16, i17, i18, i19, i26, i27, i28, i29, i36);
        } else {
            rsnScriptForEachClipped(this.mContext, i3, i16, i17, i18, bArr, i19, i26, i27, i28, i29, i36);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nScriptGroupCreate(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        validate();
        return rsnScriptGroupCreate(this.mContext, iArr, iArr2, iArr3, iArr4, iArr5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptGroupExecute(int i3) {
        validate();
        rsnScriptGroupExecute(this.mContext, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptGroupSetInput(int i3, int i16, int i17) {
        validate();
        rsnScriptGroupSetInput(this.mContext, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptGroupSetOutput(int i3, int i16, int i17) {
        validate();
        rsnScriptGroupSetOutput(this.mContext, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nScriptIntrinsicCreate(int i3, int i16) {
        validate();
        return rsnScriptIntrinsicCreate(this.mContext, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptInvoke(int i3, int i16) {
        validate();
        rsnScriptInvoke(this.mContext, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptInvokeV(int i3, int i16, byte[] bArr) {
        validate();
        rsnScriptInvokeV(this.mContext, i3, i16, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nScriptKernelIDCreate(int i3, int i16, int i17) {
        validate();
        return rsnScriptKernelIDCreate(this.mContext, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetTimeZone(int i3, byte[] bArr) {
        validate();
        rsnScriptSetTimeZone(this.mContext, i3, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarD(int i3, int i16, double d16) {
        validate();
        rsnScriptSetVarD(this.mContext, i3, i16, d16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarF(int i3, int i16, float f16) {
        validate();
        rsnScriptSetVarF(this.mContext, i3, i16, f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarI(int i3, int i16, int i17) {
        validate();
        rsnScriptSetVarI(this.mContext, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarJ(int i3, int i16, long j3) {
        validate();
        rsnScriptSetVarJ(this.mContext, i3, i16, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarObj(int i3, int i16, int i17) {
        validate();
        rsnScriptSetVarObj(this.mContext, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarV(int i3, int i16, byte[] bArr) {
        validate();
        rsnScriptSetVarV(this.mContext, i3, i16, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarVE(int i3, int i16, byte[] bArr, int i17, int[] iArr) {
        validate();
        rsnScriptSetVarVE(this.mContext, i3, i16, bArr, i17, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int nTypeCreate(int i3, int i16, int i17, int i18, boolean z16, boolean z17, int i19) {
        validate();
        return rsnTypeCreate(this.mContext, i3, i16, i17, i18, z16, z17, i19);
    }

    synchronized void nTypeGetNativeData(int i3, int[] iArr) {
        validate();
        rsnTypeGetNativeData(this.mContext, i3, iArr);
    }

    native void rsnAllocationCopyFromBitmap(int i3, int i16, Bitmap bitmap);

    native void rsnAllocationCopyToBitmap(int i3, int i16, Bitmap bitmap);

    native int rsnAllocationCreateBitmapBackedAllocation(int i3, int i16, int i17, Bitmap bitmap, int i18);

    native int rsnAllocationCreateBitmapRef(int i3, int i16, Bitmap bitmap);

    native int rsnAllocationCreateFromAssetStream(int i3, int i16, int i17, int i18);

    native int rsnAllocationCreateFromBitmap(int i3, int i16, int i17, Bitmap bitmap, int i18);

    native int rsnAllocationCreateTyped(int i3, int i16, int i17, int i18, int i19);

    native int rsnAllocationCubeCreateFromBitmap(int i3, int i16, int i17, Bitmap bitmap, int i18);

    native void rsnAllocationData1D(int i3, int i16, int i17, int i18, int i19, byte[] bArr, int i26);

    native void rsnAllocationData1D(int i3, int i16, int i17, int i18, int i19, float[] fArr, int i26);

    native void rsnAllocationData1D(int i3, int i16, int i17, int i18, int i19, int[] iArr, int i26);

    native void rsnAllocationData1D(int i3, int i16, int i17, int i18, int i19, short[] sArr, int i26);

    native void rsnAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39);

    native void rsnAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, byte[] bArr, int i29);

    native void rsnAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, float[] fArr, int i29);

    native void rsnAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int[] iArr, int i29);

    native void rsnAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, short[] sArr, int i29);

    native void rsnAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, Bitmap bitmap);

    native void rsnAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46);

    native void rsnAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, byte[] bArr, int i36);

    native void rsnAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, float[] fArr, int i36);

    native void rsnAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int[] iArr, int i36);

    native void rsnAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, short[] sArr, int i36);

    native void rsnAllocationElementData1D(int i3, int i16, int i17, int i18, int i19, byte[] bArr, int i26);

    native void rsnAllocationGenerateMipmaps(int i3, int i16);

    native int rsnAllocationGetType(int i3, int i16);

    native void rsnAllocationIoReceive(int i3, int i16);

    native void rsnAllocationIoSend(int i3, int i16);

    native void rsnAllocationRead(int i3, int i16, byte[] bArr);

    native void rsnAllocationRead(int i3, int i16, float[] fArr);

    native void rsnAllocationRead(int i3, int i16, int[] iArr);

    native void rsnAllocationRead(int i3, int i16, short[] sArr);

    native void rsnAllocationResize1D(int i3, int i16, int i17);

    native void rsnAllocationResize2D(int i3, int i16, int i17, int i18);

    native void rsnAllocationSyncAll(int i3, int i16, int i17);

    native int rsnContextCreate(int i3, int i16, int i17, int i18);

    native void rsnContextDestroy(int i3);

    native void rsnContextDump(int i3, int i16);

    native void rsnContextFinish(int i3);

    native void rsnContextSendMessage(int i3, int i16, int[] iArr);

    native void rsnContextSetPriority(int i3, int i16);

    native int rsnElementCreate(int i3, int i16, int i17, boolean z16, int i18);

    native int rsnElementCreate2(int i3, int[] iArr, String[] strArr, int[] iArr2);

    native void rsnElementGetNativeData(int i3, int i16, int[] iArr);

    native void rsnElementGetSubElements(int i3, int i16, int[] iArr, String[] strArr, int[] iArr2);

    native void rsnObjDestroy(int i3, int i16);

    native int rsnSamplerCreate(int i3, int i16, int i17, int i18, int i19, int i26, float f16);

    native void rsnScriptBindAllocation(int i3, int i16, int i17, int i18);

    native int rsnScriptCCreate(int i3, String str, String str2, byte[] bArr, int i16);

    native int rsnScriptFieldIDCreate(int i3, int i16, int i17);

    native void rsnScriptForEach(int i3, int i16, int i17, int i18, int i19);

    native void rsnScriptForEach(int i3, int i16, int i17, int i18, int i19, byte[] bArr);

    native void rsnScriptForEachClipped(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37);

    native void rsnScriptForEachClipped(int i3, int i16, int i17, int i18, int i19, byte[] bArr, int i26, int i27, int i28, int i29, int i36, int i37);

    native int rsnScriptGroupCreate(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5);

    native void rsnScriptGroupExecute(int i3, int i16);

    native void rsnScriptGroupSetInput(int i3, int i16, int i17, int i18);

    native void rsnScriptGroupSetOutput(int i3, int i16, int i17, int i18);

    native int rsnScriptIntrinsicCreate(int i3, int i16, int i17);

    native void rsnScriptInvoke(int i3, int i16, int i17);

    native void rsnScriptInvokeV(int i3, int i16, int i17, byte[] bArr);

    native int rsnScriptKernelIDCreate(int i3, int i16, int i17, int i18);

    native void rsnScriptSetTimeZone(int i3, int i16, byte[] bArr);

    native void rsnScriptSetVarD(int i3, int i16, int i17, double d16);

    native void rsnScriptSetVarF(int i3, int i16, int i17, float f16);

    native void rsnScriptSetVarI(int i3, int i16, int i17, int i18);

    native void rsnScriptSetVarJ(int i3, int i16, int i17, long j3);

    native void rsnScriptSetVarObj(int i3, int i16, int i17, int i18);

    native void rsnScriptSetVarV(int i3, int i16, int i17, byte[] bArr);

    native void rsnScriptSetVarVE(int i3, int i16, int i17, byte[] bArr, int i18, int[] iArr);

    native int rsnTypeCreate(int i3, int i16, int i17, int i18, int i19, boolean z16, boolean z17, int i26);

    native void rsnTypeGetNativeData(int i3, int i16, int[] iArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int safeID(BaseObj baseObj) {
        if (baseObj != null) {
            return baseObj.getID(this);
        }
        return 0;
    }

    public void sendMessage(int i3, int[] iArr) {
        nContextSendMessage(i3, iArr);
    }

    public void setErrorHandler(RSErrorHandler rSErrorHandler) {
        this.mErrorCallback = rSErrorHandler;
        if (isNative) {
            ((RenderScriptThunker) this).mN.setErrorHandler(new RenderScript.RSErrorHandler() { // from class: android.support.v8.renderscript.RenderScript.2
                @Override // android.renderscript.RenderScript.RSErrorHandler, java.lang.Runnable
                public void run() {
                    RSErrorHandler rSErrorHandler2 = RenderScript.this.mErrorCallback;
                    rSErrorHandler2.mErrorMessage = ((RenderScript.RSErrorHandler) this).mErrorMessage;
                    rSErrorHandler2.mErrorNum = ((RenderScript.RSErrorHandler) this).mErrorNum;
                    rSErrorHandler2.run();
                }
            });
        }
    }

    public void setMessageHandler(RSMessageHandler rSMessageHandler) {
        this.mMessageCallback = rSMessageHandler;
        if (isNative) {
            ((RenderScriptThunker) this).mN.setMessageHandler(new RenderScript.RSMessageHandler() { // from class: android.support.v8.renderscript.RenderScript.1
                @Override // android.renderscript.RenderScript.RSMessageHandler, java.lang.Runnable
                public void run() {
                    RSMessageHandler rSMessageHandler2 = RenderScript.this.mMessageCallback;
                    rSMessageHandler2.mData = ((RenderScript.RSMessageHandler) this).mData;
                    rSMessageHandler2.mID = ((RenderScript.RSMessageHandler) this).mID;
                    rSMessageHandler2.mLength = ((RenderScript.RSMessageHandler) this).mLength;
                    rSMessageHandler2.run();
                }
            });
        }
    }

    public void setPriority(Priority priority) {
        validate();
        nContextSetPriority(priority.mID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void validate() {
        if (this.mContext != 0) {
        } else {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }

    public static RenderScript create(Context context, int i3, ContextType contextType) {
        RenderScript renderScript = new RenderScript(context);
        if (shouldThunk()) {
            Log.v(LOG_TAG, "RS native mode");
            return RenderScriptThunker.create(context, i3);
        }
        synchronized (lock) {
            if (!sInitialized) {
                try {
                    Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                    sRuntime = cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]);
                    Class<?> cls2 = Integer.TYPE;
                    registerNativeAllocation = cls.getDeclaredMethod("registerNativeAllocation", cls2);
                    registerNativeFree = cls.getDeclaredMethod("registerNativeFree", cls2);
                    sUseGCHooks = true;
                } catch (Exception unused) {
                    Log.e(LOG_TAG, "No GC methods");
                    sUseGCHooks = false;
                }
                try {
                    System.loadLibrary("RSSupport");
                    System.loadLibrary("rsjni");
                    sInitialized = true;
                } catch (UnsatisfiedLinkError e16) {
                    Log.e(LOG_TAG, "Error loading RS jni library: " + e16);
                    throw new RSRuntimeException("Error loading RS jni library: " + e16);
                }
            }
        }
        Log.v(LOG_TAG, "RS compat mode");
        int nDeviceCreate = renderScript.nDeviceCreate();
        renderScript.mDev = nDeviceCreate;
        int nContextCreate = renderScript.nContextCreate(nDeviceCreate, 0, i3, contextType.mID);
        renderScript.mContext = nContextCreate;
        if (nContextCreate != 0) {
            MessageThread messageThread = new MessageThread(renderScript);
            renderScript.mMessageThread = messageThread;
            messageThread.start();
            return renderScript;
        }
        throw new RSDriverException("Failed to create RS context.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData1D(int i3, int i16, int i17, int i18, short[] sArr, int i19) {
        validate();
        rsnAllocationData1D(this.mContext, i3, i16, i17, i18, sArr, i19);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, byte[] bArr, int i28) {
        validate();
        rsnAllocationData2D(this.mContext, i3, i16, i17, i18, i19, i26, i27, bArr, i28);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, byte[] bArr, int i29) {
        validate();
        rsnAllocationData3D(this.mContext, i3, i16, i17, i18, i19, i26, i27, i28, bArr, i29);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationRead(int i3, short[] sArr) {
        validate();
        rsnAllocationRead(this.mContext, i3, sArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData1D(int i3, int i16, int i17, int i18, byte[] bArr, int i19) {
        validate();
        rsnAllocationData1D(this.mContext, i3, i16, i17, i18, bArr, i19);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, short[] sArr, int i28) {
        validate();
        rsnAllocationData2D(this.mContext, i3, i16, i17, i18, i19, i26, i27, sArr, i28);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, short[] sArr, int i29) {
        validate();
        rsnAllocationData3D(this.mContext, i3, i16, i17, i18, i19, i26, i27, i28, sArr, i29);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationRead(int i3, int[] iArr) {
        validate();
        rsnAllocationRead(this.mContext, i3, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData1D(int i3, int i16, int i17, int i18, float[] fArr, int i19) {
        validate();
        rsnAllocationData1D(this.mContext, i3, i16, i17, i18, fArr, i19);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int[] iArr, int i28) {
        validate();
        rsnAllocationData2D(this.mContext, i3, i16, i17, i18, i19, i26, i27, iArr, i28);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int[] iArr, int i29) {
        validate();
        rsnAllocationData3D(this.mContext, i3, i16, i17, i18, i19, i26, i27, i28, iArr, i29);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationRead(int i3, float[] fArr) {
        validate();
        rsnAllocationRead(this.mContext, i3, fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float[] fArr, int i28) {
        validate();
        rsnAllocationData2D(this.mContext, i3, i16, i17, i18, i19, i26, i27, fArr, i28);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData3D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, float[] fArr, int i29) {
        validate();
        rsnAllocationData3D(this.mContext, i3, i16, i17, i18, i19, i26, i27, i28, fArr, i29);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(int i3, int i16, int i17, int i18, int i19, Bitmap bitmap) {
        validate();
        rsnAllocationData2D(this.mContext, i3, i16, i17, i18, i19, bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RSErrorHandler implements Runnable {
        protected String mErrorMessage;
        protected int mErrorNum;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RSMessageHandler implements Runnable {
        protected int[] mData;
        protected int mID;
        protected int mLength;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static RenderScript create(Context context) {
        return create(context, ContextType.NORMAL);
    }

    public static RenderScript create(Context context, ContextType contextType) {
        return create(context, context.getApplicationInfo().targetSdkVersion, contextType);
    }
}
