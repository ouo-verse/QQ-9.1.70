package com.tencent.mobileqq.hermes.share;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hermes.share.HermesShareActionManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/hermes/share/HermesAbsShareAction;", "", "Lcom/tencent/mobileqq/hermes/share/k;", "shareContext", "", "g", "f", NodeProps.VISIBLE, "", tl.h.F, "", "", "e", "Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager$ShareLine;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "i", "(Lcom/tencent/mobileqq/hermes/share/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/Bitmap$CompressFormat;", "Landroid/graphics/Bitmap$CompressFormat;", "PHOTO_COMPRESS_FORMAT", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Lazy;", "c", "()Lkotlinx/coroutines/CoroutineScope;", "mainScope", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public abstract class HermesAbsShareAction {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bitmap.CompressFormat PHOTO_COMPRESS_FORMAT;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mainScope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/HermesAbsShareAction$a;", "", "", "CACHE_PHOTO_DIR_NAME", "Ljava/lang/String;", "PHOTO_COMPRESS_MIME_TYPE", "PHOTO_FILE_EXTENSION", "TAG", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.hermes.share.HermesAbsShareAction$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HermesAbsShareAction() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.PHOTO_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
        lazy = LazyKt__LazyJVMKt.lazy(HermesAbsShareAction$mainScope$2.INSTANCE);
        this.mainScope = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b4: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:181), block:B:28:0x00b4 */
    @Nullable
    public final String a(@NotNull Bitmap bitmap) {
        BufferedOutputStream bufferedOutputStream;
        Flushable flushable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bitmap);
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        String str = "temp_hermes_share_" + System.currentTimeMillis() + ".jpg";
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "hermes").getAbsolutePath()));
        file.mkdirs();
        Flushable flushable2 = null;
        if (file.canWrite()) {
            File file2 = new File(file.getAbsolutePath(), str);
            String absolutePath = file2.getAbsolutePath();
            if (file2.exists()) {
                file2.delete();
            }
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                } catch (Exception e16) {
                    e = e16;
                    bufferedOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    RFWIOUtil.flushAll(flushable2);
                    RFWIOUtil.closeAll(flushable2);
                    throw th;
                }
                try {
                    bitmap.compress(this.PHOTO_COMPRESS_FORMAT, 100, bufferedOutputStream);
                    RFWIOUtil.flushAll(bufferedOutputStream);
                    RFWIOUtil.closeAll(bufferedOutputStream);
                    return absolutePath;
                } catch (Exception e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.d("HermesAbsShareAction", 2, e.getMessage());
                    }
                    RFWIOUtil.flushAll(bufferedOutputStream);
                    RFWIOUtil.closeAll(bufferedOutputStream);
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                flushable2 = flushable;
                RFWIOUtil.flushAll(flushable2);
                RFWIOUtil.closeAll(flushable2);
                throw th;
            }
        }
        return null;
    }

    public abstract void b(@NotNull k shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item);

    @NotNull
    public final CoroutineScope c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (CoroutineScope) this.mainScope.getValue();
    }

    @NotNull
    public abstract HermesShareActionManager.ShareLine d();

    @NotNull
    public abstract List<Integer> e();

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public boolean g(@NotNull k shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return true;
    }

    public void h(@NotNull k shareContext, boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, shareContext, Boolean.valueOf(visible));
        } else {
            Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af A[Catch: OutOfMemoryError -> 0x00b7, TRY_LEAVE, TryCatch #1 {OutOfMemoryError -> 0x00b7, blocks: (B:18:0x003d, B:19:0x00a5, B:21:0x00af), top: B:17:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(@NotNull k kVar, @NotNull Continuation<? super String> continuation) {
        HermesAbsShareAction$saveBitmapToCacheFile$1 hermesAbsShareAction$saveBitmapToCacheFile$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, (Object) kVar, (Object) continuation);
        }
        if (continuation instanceof HermesAbsShareAction$saveBitmapToCacheFile$1) {
            hermesAbsShareAction$saveBitmapToCacheFile$1 = (HermesAbsShareAction$saveBitmapToCacheFile$1) continuation;
            int i16 = hermesAbsShareAction$saveBitmapToCacheFile$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                hermesAbsShareAction$saveBitmapToCacheFile$1.label = i16 - Integer.MIN_VALUE;
                Object obj = hermesAbsShareAction$saveBitmapToCacheFile$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = hermesAbsShareAction$saveBitmapToCacheFile$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) hermesAbsShareAction$saveBitmapToCacheFile$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (OutOfMemoryError unused) {
                            QQToastUtil.showQQToast(1, "\u5185\u5b58\u4e0d\u8db3\uff0c\u5206\u4eab\u5931\u8d25");
                            return objectRef.element;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (kVar.f() == null) {
                        kVar.g().i(kVar.a());
                        kVar.h(kVar.g().e());
                        kVar.g().b();
                    }
                    Bitmap f16 = kVar.f();
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = "";
                    if (f16 == null) {
                        QLog.e("HermesAbsShareAction", 1, "shareToQQFriend error, bitmap is null!");
                        QQToastUtil.showQQToast(1, R.string.f158811qm);
                        return objectRef2.element;
                    }
                    try {
                        CoroutineDispatcher io5 = Dispatchers.getIO();
                        HermesAbsShareAction$saveBitmapToCacheFile$2 hermesAbsShareAction$saveBitmapToCacheFile$2 = new HermesAbsShareAction$saveBitmapToCacheFile$2(objectRef2, this, f16, null);
                        hermesAbsShareAction$saveBitmapToCacheFile$1.L$0 = objectRef2;
                        hermesAbsShareAction$saveBitmapToCacheFile$1.label = 1;
                        if (BuildersKt.withContext(io5, hermesAbsShareAction$saveBitmapToCacheFile$2, hermesAbsShareAction$saveBitmapToCacheFile$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (OutOfMemoryError unused2) {
                        objectRef = objectRef2;
                        QQToastUtil.showQQToast(1, "\u5185\u5b58\u4e0d\u8db3\uff0c\u5206\u4eab\u5931\u8d25");
                        return objectRef.element;
                    }
                }
                if (TextUtils.isEmpty((CharSequence) objectRef.element)) {
                    QQToastUtil.showQQToast(1, R.string.f158791qk);
                    return "";
                }
                return objectRef.element;
            }
        }
        hermesAbsShareAction$saveBitmapToCacheFile$1 = new HermesAbsShareAction$saveBitmapToCacheFile$1(this, continuation);
        Object obj2 = hermesAbsShareAction$saveBitmapToCacheFile$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = hermesAbsShareAction$saveBitmapToCacheFile$1.label;
        if (i3 == 0) {
        }
        if (TextUtils.isEmpty((CharSequence) objectRef.element)) {
        }
        return objectRef.element;
    }
}
