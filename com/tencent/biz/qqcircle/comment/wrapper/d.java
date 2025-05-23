package com.tencent.biz.qqcircle.comment.wrapper;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\r\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001d\u00a8\u0006("}, d2 = {"Lcom/tencent/biz/qqcircle/comment/wrapper/d;", "", "", "b", "c", "a", "Landroid/view/View;", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/qqcircle/comment/abovebar/a;", "Lcom/tencent/biz/qqcircle/comment/abovebar/a;", "getHost", "()Lcom/tencent/biz/qqcircle/comment/abovebar/a;", "setHost", "(Lcom/tencent/biz/qqcircle/comment/abovebar/a;)V", "host", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "mSyncTipsLl", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "mTipsTv", "", "e", "Z", "mIsNeedShow", "", "f", "Ljava/lang/String;", "mTipsContent", "g", "mEnableShow", "<init>", "(Landroid/view/View;Lcom/tencent/biz/qqcircle/comment/abovebar/a;)V", tl.h.F, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.biz.qqcircle.comment.abovebar.a host;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mSyncTipsLl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTipsTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mIsNeedShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mTipsContent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean mEnableShow;

    public d(@NotNull View rootView, @NotNull com.tencent.biz.qqcircle.comment.abovebar.a host) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(host, "host");
        this.rootView = rootView;
        this.host = host;
        QFSCommentInputWindowConfig R4 = host.R4();
        if (R4 != null) {
            z16 = R4.enableShowQQVideoCommentPublicTips;
        } else {
            z16 = false;
        }
        this.mIsNeedShow = z16;
        QFSCommentInputWindowConfig R42 = this.host.R4();
        if (R42 != null) {
            str = R42.qqVideoCommentPublicTipsContent;
        } else {
            str = null;
        }
        this.mTipsContent = str == null ? "" : str;
        b();
    }

    public final void a() {
        QLog.d("QFSCommentQQVideoSyncTipsWrapper", 1, "[dismiss]");
        ViewGroup viewGroup = this.mSyncTipsLl;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void b() {
        ViewGroup viewGroup;
        boolean z16;
        boolean z17 = false;
        if (this.mIsNeedShow) {
            if (this.mTipsContent.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        this.mEnableShow = z17;
        QLog.d("QFSCommentQQVideoSyncTipsWrapper", 1, "[inflateView] mIsNeedShow=" + this.mIsNeedShow + ", mTipsContent=" + this.mTipsContent);
        if (!this.mEnableShow || this.mSyncTipsLl != null) {
            return;
        }
        View findViewById = this.rootView.findViewById(R.id.f57402n8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026mment_qq_video_sync_tips)");
        View inflate = ((ViewStub) findViewById).inflate();
        TextView textView = null;
        if (inflate instanceof ViewGroup) {
            viewGroup = (ViewGroup) inflate;
        } else {
            viewGroup = null;
        }
        this.mSyncTipsLl = viewGroup;
        if (viewGroup != null) {
            textView = (TextView) viewGroup.findViewById(R.id.f3625142);
        }
        this.mTipsTv = textView;
        ViewGroup viewGroup2 = this.mSyncTipsLl;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
    }

    public final void c() {
        QLog.d("QFSCommentQQVideoSyncTipsWrapper", 1, "[show]");
        ViewGroup viewGroup = this.mSyncTipsLl;
        if (viewGroup != null) {
            if (this.mEnableShow) {
                viewGroup.setVisibility(0);
                TextView textView = this.mTipsTv;
                if (textView != null) {
                    textView.setText(this.mTipsContent);
                    return;
                }
                return;
            }
            viewGroup.setVisibility(8);
        }
    }
}
