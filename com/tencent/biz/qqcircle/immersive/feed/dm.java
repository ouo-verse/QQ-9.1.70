package com.tencent.biz.qqcircle.immersive.feed;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.event.QFSRefreshTabEvent;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002EFB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0007H\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00103R\u0016\u0010A\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/dm;", "Lcom/tencent/biz/qqcircle/immersive/feed/b;", "Landroid/view/View$OnClickListener;", "", ICustomDataEditor.STRING_PARAM_1, "r1", "t1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "w1", "z1", "y1", "A1", "", "", "selectedItems", "", "C1", "isEnable", "u1", "v1", "x1", "p1", "", "subActionType", "q1", "N0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "position", "j1", "w0", "v", NodeProps.ON_CLICK, "Ld70/a;", ExifInterface.LATITUDE_SOUTH, "Ld70/a;", "mViewModel", "Landroidx/lifecycle/Observer;", "T", "Landroidx/lifecycle/Observer;", "mInterestTagSetObserver", "Lcom/tencent/biz/qqcircle/immersive/adapter/f;", "U", "Lcom/tencent/biz/qqcircle/immersive/adapter/f;", "mAdapter", "Landroid/widget/TextView;", "V", "Landroid/widget/TextView;", "mTitleText", "W", "mSubtitleText", "X", "mTvAction", "Landroid/widget/LinearLayout;", "Y", "Landroid/widget/LinearLayout;", "mLLRefresh", "Z", "mMoreVideoText", "a0", "Ljava/lang/String;", "mToast", "<init>", "()V", "b0", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class dm extends com.tencent.biz.qqcircle.immersive.feed.b implements View.OnClickListener {

    /* renamed from: S, reason: from kotlin metadata */
    private d70.a mViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    private Observer<Set<String>> mInterestTagSetObserver;

    /* renamed from: U, reason: from kotlin metadata */
    private com.tencent.biz.qqcircle.immersive.adapter.f mAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView mTitleText;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView mSubtitleText;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView mTvAction;

    /* renamed from: Y, reason: from kotlin metadata */
    private LinearLayout mLLRefresh;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView mMoreVideoText;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mToast = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/dm$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", ReportConstant.COSTREPORT_PREFIX, "", "", "getDynamicParams", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/immersive/feed/dm;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "mWrfPresenter", "view", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/feed/dm;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<dm> mWrfPresenter;

        public b(@NotNull dm view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.mWrfPresenter = new WeakReference<>(view);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@NotNull String s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
            dm dmVar = this.mWrfPresenter.get();
            if (dmVar == null) {
                Intrinsics.checkNotNullExpressionValue(params, "params");
                return params;
            }
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAG_NAME, dmVar.p1());
            d70.a aVar = dmVar.mViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar = null;
            }
            params.put("xsj_amount", Integer.valueOf(aVar.U1().size()));
            return params;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/dm$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = ViewUtils.dpToPx(14.0f);
            outRect.bottom = ViewUtils.dpToPx(12.0f);
        }
    }

    private final void A1() {
        BaseViewModel A0 = A0(d70.a.class);
        Intrinsics.checkNotNullExpressionValue(A0, "getViewModel(QFSInterestTagViewModel::class.java)");
        this.mViewModel = (d70.a) A0;
        this.mInterestTagSetObserver = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.feed.dl
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                dm.B1(dm.this, (Set) obj);
            }
        };
        d70.a aVar = this.mViewModel;
        Observer<Set<String>> observer = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        MutableLiveData<Set<String>> T1 = aVar.T1();
        Fragment hostFragment = s0().getHostFragment();
        Observer<Set<String>> observer2 = this.mInterestTagSetObserver;
        if (observer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInterestTagSetObserver");
        } else {
            observer = observer2;
        }
        T1.observe(hostFragment, observer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(dm this$0, Set selectedItems) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        boolean C1 = this$0.C1(selectedItems);
        TextView textView = this$0.mTvAction;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvAction");
            textView = null;
        }
        textView.setEnabled(C1);
        TextView textView3 = this$0.mTvAction;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvAction");
        } else {
            textView2 = textView3;
        }
        textView2.setText(this$0.u1(C1));
    }

    private final boolean C1(Set<String> selectedItems) {
        return !selectedItems.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1() {
        VideoReport.traverseExposure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p1() {
        d70.a aVar = this.mViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        Set<String> U1 = aVar.U1();
        if (U1.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = U1.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(",");
        }
        sb5.deleteCharAt(sb5.length() - 1);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "tags.toString()");
        return sb6;
    }

    private final void q1(int subActionType) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(160).setSubActionType(subActionType).setExt10(p1()).setPageId(y0()));
    }

    private final void r1() {
        TextView textView = this.mTvAction;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvAction");
            textView = null;
        }
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_INTEREST_COLLECTION_SUBMIT_BUTTON);
        TextView textView3 = this.mTvAction;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvAction");
            textView3 = null;
        }
        VideoReport.setElementExposePolicy(textView3, ExposurePolicy.REPORT_NONE);
        TextView textView4 = this.mTvAction;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvAction");
        } else {
            textView2 = textView4;
        }
        VideoReport.setEventDynamicParams(textView2, new b(this));
    }

    private final void s1() {
        r1();
        t1();
    }

    private final void t1() {
        LinearLayout linearLayout = this.mLLRefresh;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLLRefresh");
            linearLayout = null;
        }
        VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_INTEREST_COLLECTION_SWITCH_BUTTON);
        LinearLayout linearLayout3 = this.mLLRefresh;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLLRefresh");
        } else {
            linearLayout2 = linearLayout3;
        }
        VideoReport.setElementExposePolicy(linearLayout2, ExposurePolicy.REPORT_NONE);
    }

    private final String u1(boolean isEnable) {
        if (isEnable) {
            Context m06 = m0();
            Object[] objArr = new Object[1];
            d70.a aVar = this.mViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar = null;
            }
            objArr[0] = Integer.valueOf(aVar.U1().size());
            String string = m06.getString(R.string.f19122448, objArr);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026odel.selectedTagSet.size)");
            return string;
        }
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19123449);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_layer\u2026t_tag_select_btn_default)");
        return a16;
    }

    private final void v1(View rootView) {
        ImageView imageView = (ImageView) rootView.findViewById(R.id.dvu);
        String url = QCircleSkinHelper.getInstance().getUrl("questionnaire_feed_aduan");
        Option obtain = Option.obtain();
        obtain.setUrl(url);
        obtain.setTargetView(imageView);
        obtain.setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        obtain.setEnableAutoDeleteLocalCache(false);
        obtain.setLoadingDrawableColor(0);
        obtain.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    private final void w1(View rootView) {
        View findViewById = rootView.findViewById(R.id.k56);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_action)");
        TextView textView = (TextView) findViewById;
        this.mTvAction = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvAction");
            textView = null;
        }
        textView.setOnClickListener(this);
    }

    private final void x1(View rootView) {
        ImageView imageView = (ImageView) rootView.findViewById(R.id.y0r);
        String url = QCircleSkinHelper.getInstance().getUrl("questionnaire_feed_bg");
        Option obtain = Option.obtain();
        obtain.setUrl(url);
        obtain.setTargetView(imageView);
        obtain.setRequestWidth(ViewUtils.getScreenWidth());
        obtain.setRequestHeight(ViewUtils.getScreenHeight());
        obtain.setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        obtain.setEnableAutoDeleteLocalCache(false);
        obtain.setLoadingDrawableColor(0);
        obtain.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    private final void y1(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.i4m);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
        flexboxLayoutManager.Z(0);
        flexboxLayoutManager.a0(1);
        flexboxLayoutManager.b0(0);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        com.tencent.biz.qqcircle.immersive.adapter.f fVar = new com.tencent.biz.qqcircle.immersive.adapter.f();
        this.mAdapter = fVar;
        recyclerView.setAdapter(fVar);
        recyclerView.addItemDecoration(new c());
    }

    private final void z1(View rootView) {
        View findViewById = rootView.findViewById(R.id.yqc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ll_refresh_area)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.mLLRefresh = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLLRefresh");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_title)");
        this.mTitleText = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f167057me2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_subtitle)");
        this.mSubtitleText = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f108396d0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_guide_more)");
        this.mMoreVideoText = (TextView) findViewById3;
        w1(rootView);
        z1(rootView);
        y1(rootView);
        v1(rootView);
        x1(rootView);
        A1();
        s1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1 */
    public void L0(@NotNull FeedCloudMeta$StFeed data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.L0(data, position);
        int i3 = data.dittoFeed.dittoId.get();
        RFWLog.d("QFSInterestTagPresenter", RFWLog.USR, "[onBindData] id = ", data.f398449id.get(), ",dittoId=", Integer.valueOf(i3));
        Object b16 = this.E.b(String.valueOf(i3));
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type qqcircle.QQCircleDitto.StCircleDittoDataNew");
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = ((QQCircleDitto$StCircleDittoDataNew) b16).itemContainter;
        TextView textView = this.mTitleText;
        d70.a aVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleText");
            textView = null;
        }
        textView.setText(qQCircleDitto$StItemContainer.title.get());
        TextView textView2 = this.mSubtitleText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubtitleText");
            textView2 = null;
        }
        textView2.setText(qQCircleDitto$StItemContainer.subTitle.get());
        String str = qQCircleDitto$StItemContainer.toast.get();
        Intrinsics.checkNotNullExpressionValue(str, "itemContainter.toast.get()");
        this.mToast = str;
        d70.a aVar2 = this.mViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar2 = null;
        }
        List<QQCircleDitto$StItemInfo> list = qQCircleDitto$StItemContainer.items.get();
        Intrinsics.checkNotNullExpressionValue(list, "itemContainter.items.get()");
        aVar2.Z1(data, list);
        com.tencent.biz.qqcircle.immersive.adapter.f fVar = this.mAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            fVar = null;
        }
        d70.a aVar3 = this.mViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            aVar = aVar3;
        }
        fVar.setDatas(aVar.W1());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (!fb0.a.b("QFSInterestTagPresenter" + id5, 500L)) {
            if (id5 == R.id.k56) {
                QQToast.makeText(m0(), 2, this.mToast, 0).show();
                QFSRefreshTabEvent qFSRefreshTabEvent = new QFSRefreshTabEvent(6, true);
                PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField = new PBRepeatMessageField<>(FeedCloudCommon$Entry.class);
                com.tencent.biz.qqcircle.utils.bh.a(pBRepeatMessageField, "interest_tags", p1());
                qFSRefreshTabEvent.setMapInfo(pBRepeatMessageField);
                SimpleEventBus.getInstance().dispatchEvent(qFSRefreshTabEvent);
                q1(2);
            } else if (id5 == R.id.yqc) {
                d70.a aVar = this.mViewModel;
                d70.a aVar2 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    aVar = null;
                }
                aVar.X1();
                com.tencent.biz.qqcircle.immersive.adapter.f fVar = this.mAdapter;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    fVar = null;
                }
                d70.a aVar3 = this.mViewModel;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    aVar2 = aVar3;
                }
                fVar.setDatas(aVar2.W1());
                x0().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.dk
                    @Override // java.lang.Runnable
                    public final void run() {
                        dm.D1();
                    }
                }, 50L);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@NotNull RFWFeedSelectInfo selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        super.onFeedSelected(selectInfo);
        com.tencent.biz.qqcircle.immersive.utils.bc.a(50L);
        q1(1);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSInterestTagPresenter";
    }
}
