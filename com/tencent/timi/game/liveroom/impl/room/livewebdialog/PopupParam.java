package com.tencent.timi.game.liveroom.impl.room.livewebdialog;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010%\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010/\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u00102\u001a\u00020\u0007\u00a2\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u000e\u0010\u001aR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b#\u0010!R\u0019\u0010)\u001a\u0004\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010+\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b*\u0010\u0015R\u0019\u0010/\u001a\u0004\u0018\u00010,8\u0006\u00a2\u0006\f\n\u0004\b'\u0010-\u001a\u0004\b\u001c\u0010.R\u0017\u00102\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b*\u00100\u001a\u0004\b\u0018\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", "I", "c", "()I", "height", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "showAnim", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "background", "e", tl.h.F, "transparentWebViewBg", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "title", "i", "url", "Lcom/tencent/biz/ui/TouchWebView;", "Lcom/tencent/biz/ui/TouchWebView;", "j", "()Lcom/tencent/biz/ui/TouchWebView;", "webView", "k", "isUserDialog", "Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/a;", "Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/a;", "()Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/a;", "listener", "Z", "()Z", "innerWebView", "<init>", "(Landroid/app/Activity;ILjava/lang/Boolean;Landroid/graphics/drawable/Drawable;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/ui/TouchWebView;Ljava/lang/Boolean;Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/a;Z)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.livewebdialog.k, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class PopupParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean showAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Drawable background;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean transparentWebViewBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String title;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String url;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final TouchWebView webView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean isUserDialog;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final a listener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean innerWebView;

    public PopupParam(@Nullable Activity activity, int i3, @Nullable Boolean bool, @Nullable Drawable drawable, @Nullable Boolean bool2, @Nullable String str, @Nullable String str2, @Nullable TouchWebView touchWebView, @Nullable Boolean bool3, @Nullable a aVar, boolean z16) {
        this.activity = activity;
        this.height = i3;
        this.showAnim = bool;
        this.background = drawable;
        this.transparentWebViewBg = bool2;
        this.title = str;
        this.url = str2;
        this.webView = touchWebView;
        this.isUserDialog = bool3;
        this.listener = aVar;
        this.innerWebView = z16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Drawable getBackground() {
        return this.background;
    }

    /* renamed from: c, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getInnerWebView() {
        return this.innerWebView;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final a getListener() {
        return this.listener;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PopupParam)) {
            return false;
        }
        PopupParam popupParam = (PopupParam) other;
        if (Intrinsics.areEqual(this.activity, popupParam.activity) && this.height == popupParam.height && Intrinsics.areEqual(this.showAnim, popupParam.showAnim) && Intrinsics.areEqual(this.background, popupParam.background) && Intrinsics.areEqual(this.transparentWebViewBg, popupParam.transparentWebViewBg) && Intrinsics.areEqual(this.title, popupParam.title) && Intrinsics.areEqual(this.url, popupParam.url) && Intrinsics.areEqual(this.webView, popupParam.webView) && Intrinsics.areEqual(this.isUserDialog, popupParam.isUserDialog) && Intrinsics.areEqual(this.listener, popupParam.listener) && this.innerWebView == popupParam.innerWebView) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Boolean getShowAnim() {
        return this.showAnim;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final Boolean getTransparentWebViewBg() {
        return this.transparentWebViewBg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        Activity activity = this.activity;
        int i3 = 0;
        if (activity == null) {
            hashCode = 0;
        } else {
            hashCode = activity.hashCode();
        }
        int i16 = ((hashCode * 31) + this.height) * 31;
        Boolean bool = this.showAnim;
        if (bool == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bool.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Drawable drawable = this.background;
        if (drawable == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = drawable.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Boolean bool2 = this.transparentWebViewBg;
        if (bool2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bool2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str = this.title;
        if (str == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str2 = this.url;
        if (str2 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str2.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        TouchWebView touchWebView = this.webView;
        if (touchWebView == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = touchWebView.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        Boolean bool3 = this.isUserDialog;
        if (bool3 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = bool3.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        a aVar = this.listener;
        if (aVar != null) {
            i3 = aVar.hashCode();
        }
        int i36 = (i29 + i3) * 31;
        boolean z16 = this.innerWebView;
        int i37 = z16;
        if (z16 != 0) {
            i37 = 1;
        }
        return i36 + i37;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final TouchWebView getWebView() {
        return this.webView;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final Boolean getIsUserDialog() {
        return this.isUserDialog;
    }

    @NotNull
    public String toString() {
        return "PopupParam(activity=" + this.activity + ", height=" + this.height + ", showAnim=" + this.showAnim + ", background=" + this.background + ", transparentWebViewBg=" + this.transparentWebViewBg + ", title=" + this.title + ", url=" + this.url + ", webView=" + this.webView + ", isUserDialog=" + this.isUserDialog + ", listener=" + this.listener + ", innerWebView=" + this.innerWebView + ")";
    }
}
