package com.tencent.nativepreview.wrapper.base;

import android.graphics.RectF;
import androidx.annotation.Keep;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.nativepreview.base.primitive.FileLoadCallback;
import com.tencent.nativepreview.base.primitive.NativeEngineJNI;
import com.tencent.nativepreview.wrapper.model.DocOutlineItem;
import com.tencent.nativepreview.wrapper.model.DocSearchState;
import com.tencent.nativepreview.wrapper.sheet.a;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000f\b'\u0018\u0000 X2\u00020\u0001:\u0001YB'\u0012\u0006\u0010R\u001a\u00020\u0002\u0012\u0006\u0010S\u001a\u00020\u0002\u0012\u0006\u0010T\u001a\u00020\u0006\u0012\u0006\u0010U\u001a\u00020\u0017\u00a2\u0006\u0004\bV\u0010WJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0083 J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H&J\b\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0017H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u0002H&J\u001a\u0010\"\u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010!\u001a\u00020\u001fH&J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH&J\u0017\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H&\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H&J\u0006\u0010*\u001a\u00020\u0004J0\u00100\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010/J\u0006\u00101\u001a\u00020\u0004J1\u00105\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u001022\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u000003H\u0084\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J\u0006\u00107\u001a\u00020\u0004J1\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0085 J!\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0085 J)\u0010:\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0085 J\u0011\u0010;\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0085 J\u0019\u0010<\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0017H\u0085 J\u0011\u0010=\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0085 J#\u0010?\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0085 J\u001b\u0010@\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u001bH\u0085 J\u001b\u0010A\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u001bH\u0085 J\u001b\u0010B\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u001bH\u0085 J \u0010C\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0006\u0010\u0003\u001a\u00020\u0002H\u0085 \u00a2\u0006\u0004\bC\u0010DJ!\u0010F\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u0017H\u0085 J\u0011\u0010G\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0085 J;\u0010H\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010/H\u0085 J\u0011\u0010I\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0085 J\u0006\u0010J\u001a\u00020\u0004R\"\u0010L\u001a\u00020K8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006Z"}, d2 = {"Lcom/tencent/nativepreview/wrapper/base/Editor;", "", "", "native", "", "destroyJNI", "", "path", NotificationActivity.PASSWORD, "cache", "Lcom/tencent/nativepreview/base/primitive/FileLoadCallback;", "callback", "loadFileAsync", "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, "", "ratio", "setPageSize", "", "scale", "maxScale", "minScale", "setScale", "", "getPageMode", "mode", "setPageMode", "Lcom/tencent/nativepreview/wrapper/model/DocSearchState;", "getCurrentFindState", "searchState", "offset", "", "findNext", "all", SQLiteDatabase.OPERATE_TYPE_REPLACE, "cancelFind", "", "Lcom/tencent/nativepreview/wrapper/model/DocOutlineItem;", "getOutlines", "()[Lcom/tencent/nativepreview/wrapper/model/DocOutlineItem;", "paragraphNodePtr", "scrollTo", "refreshView", "startPage", "count", "pixelRatio", "saveFold", "Lcom/tencent/nativepreview/wrapper/base/ImageExportCallback;", "exportImage", "cancelCurrentImageExport", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function1;", "block", "callNative", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "destroy", "loadFileAsyncJNI", "setPageSizeJNI", "setScaleJNI", "getPageModeJNI", "setPageModeJNI", "getCurrentFindStateJni", "state", "findNextJni", "replaceNextJni", "replaceAllJni", "cleanSearchStateJni", "getOutlinesJni", "(J)[Lcom/tencent/nativepreview/wrapper/model/DocOutlineItem;", "scrollMode", "scrollToJni", "refreshViewJni", "exportImageJni", "cancelCurrentImageExportJni", "dispose", "Ljava/util/concurrent/atomic/AtomicLong;", "nativePtr", "Ljava/util/concurrent/atomic/AtomicLong;", "getNativePtr", "()Ljava/util/concurrent/atomic/AtomicLong;", "setNativePtr", "(Ljava/util/concurrent/atomic/AtomicLong;)V", "shell", "viewContext", QAdRewardDefine$VideoParams.CACHE_PATH, "docType", "<init>", "(JJLjava/lang/String;I)V", "Factory", "a", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public abstract class Editor {
    static IPatchRedirector $redirector_;

    /* renamed from: Factory, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private AtomicLong nativePtr;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/nativepreview/wrapper/base/Editor$a;", "", "", "docType", "", "shell", "viewContext", "", QAdRewardDefine$VideoParams.CACHE_PATH, "Lcom/tencent/nativepreview/wrapper/base/Editor;", "a", "<init>", "()V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.nativepreview.wrapper.base.Editor$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final Editor a(int docType, long shell, long viewContext, @NotNull String cachePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editor) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(docType), Long.valueOf(shell), Long.valueOf(viewContext), cachePath);
            }
            Intrinsics.checkNotNullParameter(cachePath, "cachePath");
            if (docType != 0) {
                if (docType != 1) {
                    return null;
                }
                return new a(shell, viewContext, cachePath);
            }
            return new com.tencent.nativepreview.wrapper.doc.a(shell, viewContext, cachePath);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15429);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public Editor(long j3, long j16, @NotNull String cachePath, int i3) {
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), cachePath, Integer.valueOf(i3));
            return;
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        this.nativePtr = atomicLong;
        atomicLong.compareAndSet(0L, NativeEngineJNI.INSTANCE.createEditor(j3, j16, i3, true, cachePath));
    }

    @Keep
    private final native void destroyJNI(long r16);

    @Nullable
    protected final <R> R callNative(@NotNull Function1<? super Long, ? extends R> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (R) iPatchRedirector.redirect((short) 7, (Object) this, (Object) block);
        }
        Intrinsics.checkNotNullParameter(block, "block");
        long j3 = this.nativePtr.get();
        if (j3 == 0) {
            return null;
        }
        return block.invoke(Long.valueOf(j3));
    }

    public final void cancelCurrentImageExport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.nativePtr.get() != 0) {
            cancelCurrentImageExportJni(getNativePtr().get());
        }
    }

    @Keep
    protected final native void cancelCurrentImageExportJni(long r16);

    public abstract void cancelFind(@Nullable DocSearchState searchState);

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native void cleanSearchStateJni(long r16, @Nullable DocSearchState state);

    public final void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        long j3 = this.nativePtr.get();
        if (j3 != 0) {
            destroyJNI(j3);
        }
    }

    public final void dispose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        long andSet = this.nativePtr.getAndSet(0L);
        if (andSet != 0) {
            NativeEngineJNI.INSTANCE.destroyEditor(andSet);
        }
    }

    public final void exportImage(int startPage, int count, double pixelRatio, @NotNull String saveFold, @Nullable ImageExportCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(startPage), Integer.valueOf(count), Double.valueOf(pixelRatio), saveFold, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(saveFold, "saveFold");
        if (this.nativePtr.get() != 0) {
            exportImageJni(getNativePtr().get(), startPage, count, pixelRatio, saveFold, callback);
        }
    }

    @Keep
    protected final native void exportImageJni(long r16, int startPage, int count, double pixelRatio, @NotNull String saveFold, @Nullable ImageExportCallback callback);

    public abstract boolean findNext(@Nullable DocSearchState searchState, long offset);

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native boolean findNextJni(long r16, @Nullable DocSearchState state, long offset);

    @Nullable
    public abstract DocSearchState getCurrentFindState();

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    @NotNull
    public final native DocSearchState getCurrentFindStateJni(long r16);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AtomicLong getNativePtr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AtomicLong) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.nativePtr;
    }

    @Nullable
    public abstract DocOutlineItem[] getOutlines();

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    @Nullable
    public final native DocOutlineItem[] getOutlinesJni(long r16);

    public abstract int getPageMode();

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native int getPageModeJNI(long r16);

    public abstract void loadFileAsync(@NotNull String path, @NotNull String password, @NotNull String cache, @NotNull FileLoadCallback callback);

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native void loadFileAsyncJNI(long r16, @NotNull String path, @NotNull String password, @NotNull String cache, @NotNull FileLoadCallback callback);

    public final void refreshView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.nativePtr.get() != 0) {
            refreshViewJni(getNativePtr().get());
        }
    }

    @Keep
    protected final native void refreshViewJni(long r16);

    public abstract boolean replace(@Nullable DocSearchState searchState, boolean all);

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native boolean replaceAllJni(long r16, @Nullable DocSearchState state);

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native boolean replaceNextJni(long r16, @Nullable DocSearchState state);

    public abstract void scrollTo(long paragraphNodePtr);

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native void scrollToJni(long r16, long paragraphNodePtr, int scrollMode);

    protected final void setNativePtr(@NotNull AtomicLong atomicLong) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) atomicLong);
        } else {
            Intrinsics.checkNotNullParameter(atomicLong, "<set-?>");
            this.nativePtr = atomicLong;
        }
    }

    public abstract void setPageMode(int mode);

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native void setPageModeJNI(long r16, int mode);

    public abstract void setPageSize(@NotNull RectF rect, float ratio);

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native void setPageSizeJNI(long r16, @NotNull RectF rect, float ratio);

    public abstract void setScale(double scale, double maxScale, double minScale);

    /* JADX INFO: Access modifiers changed from: protected */
    @Keep
    public final native void setScaleJNI(long r16, double scale, double maxScale, double minScale);
}
