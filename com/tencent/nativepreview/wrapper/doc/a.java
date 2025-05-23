package com.tencent.nativepreview.wrapper.doc;

import android.graphics.RectF;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.nativepreview.base.primitive.FileLoadCallback;
import com.tencent.nativepreview.wrapper.base.Editor;
import com.tencent.nativepreview.wrapper.model.DocOutlineItem;
import com.tencent.nativepreview.wrapper.model.DocSearchState;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010(\u001a\u00020\u001b\u0012\u0006\u0010)\u001a\u00020\u001b\u0012\u0006\u0010*\u001a\u00020\u0002\u00a2\u0006\u0004\b+\u0010,J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010 \u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0012\u0010!\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0016J\u0017\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u001bH\u0016\u00a8\u0006-"}, d2 = {"Lcom/tencent/nativepreview/wrapper/doc/a;", "Lcom/tencent/nativepreview/wrapper/base/Editor;", "", "path", NotificationActivity.PASSWORD, "cache", "Lcom/tencent/nativepreview/base/primitive/FileLoadCallback;", "callback", "", "loadFileAsync", "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, "", "ratio", "setPageSize", "", "scale", "maxScale", "minScale", "setScale", "", "getPageMode", "mode", "setPageMode", "Lcom/tencent/nativepreview/wrapper/model/DocSearchState;", "getCurrentFindState", "searchState", "", "offset", "", "findNext", "all", SQLiteDatabase.OPERATE_TYPE_REPLACE, "cancelFind", "", "Lcom/tencent/nativepreview/wrapper/model/DocOutlineItem;", "getOutlines", "()[Lcom/tencent/nativepreview/wrapper/model/DocOutlineItem;", "paragraphNodePtr", "scrollTo", "shell", "viewContext", QAdRewardDefine$VideoParams.CACHE_PATH, "<init>", "(JJLjava/lang/String;)V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public final class a extends Editor {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(long j3, long j16, @NotNull String cachePath) {
        super(j3, j16, cachePath, 0);
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), cachePath);
        }
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    public void cancelFind(@Nullable DocSearchState searchState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) searchState);
        } else if (((Editor) this).nativePtr.get() != 0) {
            cleanSearchStateJni(getNativePtr().get(), searchState);
        }
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    public boolean findNext(@Nullable DocSearchState searchState, long offset) {
        Boolean valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, searchState, Long.valueOf(offset))).booleanValue();
        }
        if (((Editor) this).nativePtr.get() == 0) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(findNextJni(getNativePtr().get(), searchState, offset));
        }
        if (valueOf == null) {
            return false;
        }
        return valueOf.booleanValue();
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    @Nullable
    public DocSearchState getCurrentFindState() {
        DocSearchState currentFindStateJni;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (DocSearchState) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (((Editor) this).nativePtr.get() == 0) {
            currentFindStateJni = null;
        } else {
            currentFindStateJni = getCurrentFindStateJni(getNativePtr().get());
        }
        if (currentFindStateJni == null) {
            return null;
        }
        return currentFindStateJni;
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    @Nullable
    public DocOutlineItem[] getOutlines() {
        DocOutlineItem[] outlinesJni;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (DocOutlineItem[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (((Editor) this).nativePtr.get() == 0) {
            outlinesJni = null;
        } else {
            outlinesJni = getOutlinesJni(getNativePtr().get());
        }
        if (outlinesJni == null) {
            return new DocOutlineItem[0];
        }
        return outlinesJni;
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    public int getPageMode() {
        Integer valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (((Editor) this).nativePtr.get() == 0) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(getPageModeJNI(getNativePtr().get()));
        }
        if (valueOf == null) {
            return 0;
        }
        return valueOf.intValue();
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    public void loadFileAsync(@NotNull String path, @NotNull String password, @NotNull String cache, @NotNull FileLoadCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, path, password, cache, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(callback, "callback");
        long j3 = ((Editor) this).nativePtr.get();
        if (j3 != 0) {
            loadFileAsyncJNI(j3, path, password, cache, callback);
        }
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    public boolean replace(@Nullable DocSearchState searchState, boolean all) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, searchState, Boolean.valueOf(all))).booleanValue();
        }
        Boolean bool = null;
        if (all) {
            if (((Editor) this).nativePtr.get() != 0) {
                bool = Boolean.valueOf(replaceAllJni(getNativePtr().get(), searchState));
            }
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        if (((Editor) this).nativePtr.get() != 0) {
            bool = Boolean.valueOf(replaceNextJni(getNativePtr().get(), searchState));
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    public void scrollTo(long paragraphNodePtr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, paragraphNodePtr);
        } else if (((Editor) this).nativePtr.get() != 0) {
            scrollToJni(getNativePtr().get(), paragraphNodePtr, 1);
        }
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    public void setPageMode(int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, mode);
            return;
        }
        long j3 = ((Editor) this).nativePtr.get();
        if (j3 != 0) {
            setPageModeJNI(j3, mode);
        }
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    public void setPageSize(@NotNull RectF rect, float ratio) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, rect, Float.valueOf(ratio));
            return;
        }
        Intrinsics.checkNotNullParameter(rect, "rect");
        long j3 = ((Editor) this).nativePtr.get();
        if (j3 != 0) {
            setPageSizeJNI(j3, rect, ratio);
        }
    }

    @Override // com.tencent.nativepreview.wrapper.base.Editor
    public void setScale(double scale, double maxScale, double minScale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Double.valueOf(scale), Double.valueOf(maxScale), Double.valueOf(minScale));
            return;
        }
        long j3 = ((Editor) this).nativePtr.get();
        if (j3 != 0) {
            setScaleJNI(j3, scale, maxScale, minScale);
        }
    }
}
