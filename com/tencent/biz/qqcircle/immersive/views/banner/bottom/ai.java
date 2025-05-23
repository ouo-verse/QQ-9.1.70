package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 :2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ$\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0004J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H$J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0014J\b\u0010\u001b\u001a\u00020\bH\u0014R$\u0010\"\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010&\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010.\u001a\u0004\u0018\u00010'8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u0006<"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/ai;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/c;", "Lfeedcloud/FeedCloudCommon$StCommonExt;", "extInfo", "", HippyTKDListViewAdapter.X, "", "isOperation", "", "u", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "y", "word", BdhLogUtil.LogTag.Tag_Conn, NodeProps.VISIBLE, "B", "v", "Le30/b;", "data", "", "position", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onElementActivated", "onElementInactivated", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "D", "Landroid/view/View;", "getSearchInputBar", "()Landroid/view/View;", "setSearchInputBar", "(Landroid/view/View;)V", "searchInputBar", "E", "getMLlBottomBannerWrapper", "setMLlBottomBannerWrapper", "mLlBottomBannerWrapper", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "getSearchInputText", "()Landroid/widget/TextView;", "setSearchInputText", "(Landroid/widget/TextView;)V", "searchInputText", "G", "Ljava/lang/String;", "w", "()Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "keyword", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;", "host", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;)V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class ai extends c {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View searchInputBar;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View mLlBottomBannerWrapper;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView searchInputText;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String keyword;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(@NotNull a host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.keyword = "";
    }

    public static /* synthetic */ void D(ai aiVar, String str, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                feedCloudCommon$StCommonExt = null;
            }
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            aiVar.C(str, feedCloudCommon$StCommonExt, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showWithWord");
    }

    private final void u(FeedCloudCommon$StCommonExt extInfo, boolean isOperation) {
        if (this.f90602e == null) {
            return;
        }
        VideoReport.setElementId(this.searchInputBar, QCircleDaTongConstant.ElementId.EM_XSJ_RELATED_SEARCH_PANEL);
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_feed_id", this.f90602e.f398449id.get());
        hashMap.put("xsj_query_text", this.keyword);
        if (isOperation) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_IS_OPERATION_POSITION, 1);
        } else {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_IS_OPERATION_POSITION, 0);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_RELATED_SEARCH_TRANSFER_INFO, x(extInfo));
        }
        VideoReport.setElementParams(this.searchInputBar, hashMap);
        VideoReport.setElementEndExposePolicy(this.searchInputBar, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(this.searchInputBar, QCircleDaTongConstant.ElementId.EM_XSJ_RELATED_SEARCH_PANEL + this.f90602e.f398449id.get());
    }

    private final String x(FeedCloudCommon$StCommonExt extInfo) {
        List<FeedCloudCommon$Entry> list;
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField;
        if (extInfo != null && (pBRepeatMessageField = extInfo.mapInfo) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        if (list != null) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if (Intrinsics.areEqual("transfer_info", feedCloudCommon$Entry.key.get())) {
                    String str = feedCloudCommon$Entry.value.get();
                    Intrinsics.checkNotNullExpressionValue(str, "entry.value.get()");
                    return str;
                }
            }
            return "";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(View rootView, ai this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSSearchBean qFSSearchBean = new QFSSearchBean();
        qFSSearchBean.setQuerySource(16);
        qFSSearchBean.setUserSource(8);
        qFSSearchBean.setSearchKeyword(this$0.keyword);
        com.tencent.biz.qqcircle.launcher.c.A0(rootView.getContext(), qFSSearchBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyword = str;
    }

    public final void B(boolean visible) {
        int i3;
        View view = this.searchInputBar;
        int i16 = 0;
        if (view != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        View view2 = this.mLlBottomBannerWrapper;
        if (view2 != null) {
            if (!visible) {
                i16 = 8;
            }
            view2.setVisibility(i16);
        }
    }

    public final void C(@NotNull String word, @Nullable FeedCloudCommon$StCommonExt extInfo, boolean isOperation) {
        Intrinsics.checkNotNullParameter(word, "word");
        this.keyword = word;
        TextView textView = this.searchInputText;
        if (textView != null) {
            textView.setText(word);
        }
        B(true);
        u(extInfo, isOperation);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(@Nullable e30.b data, int position) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        super.h(data, position);
        if (data != null) {
            feedCloudMeta$StFeed = data.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        this.f90602e = feedCloudMeta$StFeed;
        QLog.d(m(), 4, "[onBindData]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    @NotNull
    public abstract String m();

    public void onElementActivated() {
        View mRootView = this.f90604h;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        y(mRootView);
        QLog.d(m(), 1, "[onElementActivated] #keyword ", this.keyword);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        B(false);
        QLog.d(m(), 1, "[onElementInactivated] #keyword ", this.keyword);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
        QLog.d(m(), 4, "[onAttached]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    public void r() {
        QLog.d(m(), 4, "[onDetached]");
    }

    @NotNull
    public final String v() {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: w, reason: from getter */
    public final String getKeyword() {
        return this.keyword;
    }

    public final void y(@NotNull final View rootView) {
        TextView textView;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.f41361gv);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.searchInputBar = inflate;
        if (inflate != null) {
            textView = (TextView) inflate.findViewById(R.id.f107946bs);
        } else {
            textView = null;
        }
        this.searchInputText = textView;
        this.mLlBottomBannerWrapper = rootView.findViewById(R.id.f34340yw);
        View view = this.searchInputBar;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.ah
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ai.z(rootView, this, view2);
                }
            });
        }
        QLog.d(m(), 1, "[makeSureInflate]");
    }
}
