package com.tencent.mobileqq.search.voicesearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.widgets.comment.f;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import hp2.aj;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0003\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005R\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!R\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/search/voicesearch/ThirdAppComponent;", "Landroid/widget/FrameLayout;", "Lcom/tencent/biz/qqcircle/widgets/comment/f$b;", "", "keyboardHeight", "", "c", "j", "Landroid/view/View;", "view", "", "eid", "k", "Lap2/g;", DownloadInfo.spKey_Config, "setConfig", "l", "d", "keyboardHeightInPx", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "pageId", "setPageId", "f", tl.h.F, "i", "Ljava/lang/String;", "reportPageId", "Lhp2/aj;", "e", "Lhp2/aj;", "binding", "Lcom/tencent/biz/qqcircle/widgets/comment/f;", "Lcom/tencent/biz/qqcircle/widgets/comment/f;", "softKeyboardStateHelper", "I", "lastSoftKeyboardHeight", "", "Z", "isSoftKeyboardOpening", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lap2/g;", "thirdAppConfig", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ThirdAppComponent extends FrameLayout implements f.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String reportPageId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private aj binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.biz.qqcircle.widgets.comment.f softKeyboardStateHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lastSoftKeyboardHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSoftKeyboardOpening;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ap2.g thirdAppConfig;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThirdAppComponent(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(int keyboardHeight) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = keyboardHeight;
            setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean e(ThirdAppComponent this$0, Context context, View view, MotionEvent motionEvent) {
        String str;
        boolean z16;
        String str2;
        String url;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (motionEvent.getAction() == 1) {
            ap2.g gVar = this$0.thirdAppConfig;
            if (gVar != null) {
                str = gVar.getUrl();
            } else {
                str = null;
            }
            QLog.i("QQSearch.NetDetail.AI.ThirdAppComponent", 1, "click url=" + str);
            ap2.g gVar2 = this$0.thirdAppConfig;
            boolean z18 = false;
            if (gVar2 != null && (url = gVar2.getUrl()) != null) {
                if (url.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (z16) {
                        ap2.g gVar3 = this$0.thirdAppConfig;
                        if (gVar3 != null) {
                            str2 = gVar3.getUrl();
                        } else {
                            str2 = null;
                        }
                        SearchUtils.Q0(null, context, str2);
                    }
                    HashMap hashMap = new HashMap();
                    if (this$0.reportPageId.length() > 0) {
                        z18 = true;
                    }
                    if (z18) {
                        hashMap.put("dt_pgid", this$0.reportPageId);
                    }
                    VideoReport.reportEvent("dt_clck", view, hashMap);
                }
            }
            z16 = false;
            if (z16) {
            }
            HashMap hashMap2 = new HashMap();
            if (this$0.reportPageId.length() > 0) {
            }
            if (z18) {
            }
            VideoReport.reportEvent("dt_clck", view, hashMap2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        ap2.f fVar = ap2.f.f26688a;
        if (fVar.a()) {
            fVar.c(fVar.b() + 1);
        }
    }

    private final void j() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = 0;
            setLayoutParams(marginLayoutParams);
        }
    }

    private final void k(View view, String eid) {
        VideoReport.setElementId(view, eid);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    public final void d() {
        LinearLayout linearLayout;
        aj ajVar = this.binding;
        if (ajVar != null) {
            linearLayout = ajVar.f405593c;
        } else {
            linearLayout = null;
        }
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void f() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.voicesearch.a
            @Override // java.lang.Runnable
            public final void run() {
                ThirdAppComponent.g();
            }
        }, 16, null, false);
    }

    public final void h() {
        this.softKeyboardStateHelper.s(this);
    }

    public final void i() {
        this.softKeyboardStateHelper.a(this);
    }

    public final void l() {
        aj ajVar;
        LinearLayout linearLayout;
        if (!this.isSoftKeyboardOpening || (ajVar = this.binding) == null || (linearLayout = ajVar.f405593c) == null || linearLayout.getVisibility() == 0) {
            return;
        }
        boolean z16 = false;
        linearLayout.setVisibility(0);
        HashMap hashMap = new HashMap();
        if (this.reportPageId.length() > 0) {
            z16 = true;
        }
        if (z16) {
            hashMap.put("dt_pgid", this.reportPageId);
        }
        VideoReport.reportEvent("dt_imp", linearLayout, hashMap);
    }

    @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
    public void onSoftKeyboardClosed() {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.ThirdAppComponent", 1, "onSoftKeyboardClosed called!", null);
        this.isSoftKeyboardOpening = false;
        j();
        d();
    }

    @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.ThirdAppComponent", 1, "onSoftKeyboardOpened called! keyboardHeightInPx=" + keyboardHeightInPx, null);
        this.lastSoftKeyboardHeight = keyboardHeightInPx;
        this.isSoftKeyboardOpening = true;
        c(keyboardHeightInPx);
    }

    public final void setConfig(@NotNull ap2.g config) {
        Intrinsics.checkNotNullParameter(config, "config");
        aj ajVar = this.binding;
        if (ajVar != null) {
            ajVar.f405594d.setText(config.getText());
        }
        this.thirdAppConfig = config;
    }

    public final void setPageId(@NotNull String pageId) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.reportPageId = pageId;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", this.reportPageId);
        aj ajVar = this.binding;
        if (ajVar != null && (linearLayout = ajVar.f405593c) != null) {
            VideoReport.setElementParams(linearLayout, hashMap);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThirdAppComponent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ThirdAppComponent(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThirdAppComponent(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportPageId = "";
        this.binding = aj.g(LayoutInflater.from(context), this, true);
        com.tencent.biz.qqcircle.widgets.comment.f fVar = new com.tencent.biz.qqcircle.widgets.comment.f(getRootView());
        this.softKeyboardStateHelper = fVar;
        fVar.a(this);
        aj ajVar = this.binding;
        if (ajVar == null || (linearLayout = ajVar.f405593c) == null) {
            return;
        }
        linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.search.voicesearch.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean e16;
                e16 = ThirdAppComponent.e(ThirdAppComponent.this, context, view, motionEvent);
                return e16;
            }
        });
        k(linearLayout, "em_bas_download_ingots");
        d();
    }
}
