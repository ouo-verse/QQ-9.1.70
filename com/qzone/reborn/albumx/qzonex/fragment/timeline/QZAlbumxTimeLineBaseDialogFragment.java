package com.qzone.reborn.albumx.qzonex.fragment.timeline;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.qzonex.fragment.timeline.QZAlbumxTimeLineBaseDialogFragment;
import com.qzone.reborn.base.n;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.TimeLineNodeType;
import com.tencent.richframework.thread.RFWThreadManager;
import hb.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import nc.bs;
import sa.b;
import za.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 72\u00020\u00012\u00020\u0002:\u0001[B\u0007\u00a2\u0006\u0004\bY\u0010ZJ&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J$\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0013H\u0002J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%J\u0010\u0010(\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010%J\u001e\u0010)\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\b\u0010*\u001a\u00020\u000bH\u0016J\u0012\u0010-\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J&\u00102\u001a\u0004\u0018\u00010\u00162\u0006\u0010/\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u0001002\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\u000e\u00106\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u000205J\n\u00107\u001a\u0004\u0018\u000105H\u0016J*\u0010;\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u00108\u001a\u0004\u0018\u00010#2\f\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u000109H\u0004J \u0010<\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\f\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u000109H\u0004J\u0006\u0010=\u001a\u00020\u000bR$\u0010D\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010?R\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006\\"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/timeline/QZAlbumxTimeLineBaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lhb/j;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "datas", "curTimeLineEvent", "", "Lza/a;", "wh", "timelineBeanList", "", "Ah", "rh", "bean", "", "th", "", "textSize", "", "text", "sh", "Landroid/view/View;", "view", "initView", "yh", "initData", "Dh", "xh", "getContentLayoutId", "Lnc/bs;", "viewModel", "uh", "pageId", "", "", "vh", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Fh", "Ch", "Hh", "onStart", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "onResume", "onDestroyView", "Lcom/qzone/reborn/base/n;", "Eh", "J", "iocBaseInterface", "Ljava/lang/Class;", "iocClass", "registerIoc", "Gh", "registerDaTongReportPageId", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lsa/b;", "D", "Lsa/b;", "timelineAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "E", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "G", "blankView", "H", "Ljava/util/List;", "dataList", "I", "Lcom/qzone/reborn/base/n;", "timeLineViewModel", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxTimeLineBaseDialogFragment extends DialogFragment implements j {

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private b timelineAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private View blankView;

    /* renamed from: H, reason: from kotlin metadata */
    private List<a> dataList = new ArrayList();

    /* renamed from: I, reason: from kotlin metadata */
    private n timeLineViewModel;

    private final void Ah(List<a> timelineBeanList) {
        if (timelineBeanList.isEmpty()) {
            return;
        }
        n nVar = this.timeLineViewModel;
        bs bsVar = nVar instanceof bs ? (bs) nVar : null;
        if (bsVar != null && (bsVar.getThemeType() == 0 || bsVar.getThemeType() == 1)) {
            if (timelineBeanList.size() <= 1) {
                timelineBeanList.get(0).f(true);
                return;
            }
            if (timelineBeanList.size() >= 2) {
                if (timelineBeanList.get(1).getEvent().getType() != TimeLineNodeType.KTIMELINENODEBIG.ordinal() && timelineBeanList.get(0).getEvent().getType() != TimeLineNodeType.KTIMELINENODESMALL.ordinal()) {
                    timelineBeanList.get(1).f(true);
                    return;
                } else {
                    timelineBeanList.get(0).f(true);
                    return;
                }
            }
            return;
        }
        timelineBeanList.get(0).f(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(QZAlbumxTimeLineBaseDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.getDialog();
        boolean z16 = false;
        if (dialog != null && dialog.isShowing()) {
            z16 = true;
        }
        if (z16) {
            this$0.dismissAllowingStateLoss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Dh() {
        int i3;
        List<a> items;
        List<a> items2;
        b bVar = this.timelineAdapter;
        int i16 = 0;
        if (bVar != null && (items2 = bVar.getItems()) != null) {
            Iterator<a> it = items2.iterator();
            i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                } else if (it.next().getIsClicked()) {
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            i3 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int i17 = i3 + 2;
        b bVar2 = this.timelineAdapter;
        if (bVar2 != null && (items = bVar2.getItems()) != null) {
            i16 = items.size();
        }
        if (i17 < i16) {
            i3 = i17;
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(i3);
    }

    private final int getContentLayoutId() {
        return R.layout.f129375w;
    }

    private final void initData() {
        registerIoc(this.rootView, this, j.class);
        rh();
        b bVar = this.timelineAdapter;
        if (bVar != null) {
            bVar.setItems(this.dataList);
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: gb.a
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxTimeLineBaseDialogFragment.zh(QZAlbumxTimeLineBaseDialogFragment.this);
            }
        }, 100L);
    }

    private final void rh() {
        int i3 = 0;
        for (a aVar : this.dataList) {
            if (aVar.getEvent().getType() == TimeLineNodeType.KTIMELINENODEBIG.ordinal()) {
                i3 = RangesKt___RangesKt.coerceAtLeast(th(aVar), i3);
            }
        }
        Iterator<T> it = this.dataList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).j(i3);
        }
    }

    private final int sh(float textSize, String text) {
        View view = this.rootView;
        Context context = view != null ? view.getContext() : null;
        if (context == null) {
            return 0;
        }
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextSize(textSize);
        textView.measure(0, 0);
        return textView.getMeasuredWidth();
    }

    private final int th(a bean) {
        int sh5 = sh(20.0f, bean.getEvent().getTitle());
        return ar.d(76.0f) + sh5 + sh(12.0f, bean.getEvent().getContent());
    }

    private final String uh(bs viewModel) {
        int from = viewModel.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String().getFrom();
        if (from == 1) {
            return "pg_qz_pic_list";
        }
        if (from == 2) {
            return "pg_qz_video_list";
        }
        if (from != 3) {
            return "";
        }
        return "pg_qz_photo_list_new";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x009a, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.getQzoneId(), com.qzone.common.account.LoginData.getInstance().getUinString()) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x009d, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x009e, code lost:
    
        r0.put(com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst.PAGE_PARAM_USERPROFILE_SETTING_HOST_GUEST_TYPE, java.lang.Integer.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0087, code lost:
    
        if (r6.equals("pg_qz_pic_list") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r6.equals("pg_qz_video_list") == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<String, Object> vh(bs viewModel, String pageId) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int hashCode = pageId.hashCode();
        int i3 = 1;
        if (hashCode != -1621929663) {
            if (hashCode != 1087047290) {
                if (hashCode == 2068943216) {
                }
            } else if (pageId.equals("pg_qz_photo_list_new")) {
                linkedHashMap.put("topic_type", Integer.valueOf(viewModel.getThemeType() + 1));
                linkedHashMap.put("albumid", viewModel.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String().getAlbumId());
                linkedHashMap.put("album_name", viewModel.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String().getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
                linkedHashMap.put("user_identity", Integer.valueOf(viewModel.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String().getCom.huawei.hms.support.feature.result.CommonConstant.KEY_USER_IDENTIFY java.lang.String()));
                linkedHashMap.put(MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME, Integer.valueOf(viewModel.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String().getCom.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME java.lang.String()));
            }
        }
        return linkedHashMap;
    }

    private final List<a> wh(List<CommonStTimeLineEvent> datas, CommonStTimeLineEvent curTimeLineEvent) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = datas.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            CommonStTimeLineEvent commonStTimeLineEvent = (CommonStTimeLineEvent) it.next();
            a aVar = new a();
            aVar.g(commonStTimeLineEvent);
            if (curTimeLineEvent != null && curTimeLineEvent.getType() == commonStTimeLineEvent.getType()) {
                if (curTimeLineEvent != null && curTimeLineEvent.getEndTime() == commonStTimeLineEvent.getEndTime()) {
                    if (curTimeLineEvent != null && curTimeLineEvent.getBeginTime() == commonStTimeLineEvent.getBeginTime()) {
                        z16 = true;
                    }
                    if (z16) {
                        aVar.f(true);
                    }
                }
            }
            arrayList.add(aVar);
        }
        if (arrayList.size() >= 1) {
            arrayList.get(0).h(true);
        }
        if (arrayList.size() > 1) {
            arrayList.get(arrayList.size() - 1).i(true);
        }
        if (curTimeLineEvent == null) {
            Ah(arrayList);
        }
        return arrayList;
    }

    private final int xh() {
        return ar.n(getContext()) + ar.d(50.0f);
    }

    private final void yh() {
        b bVar = new b();
        this.timelineAdapter = bVar;
        bVar.setHasStableIds(true);
        this.concatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.timelineAdapter});
        RecyclerView recyclerView = this.recyclerView;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(QZAlbumxTimeLineBaseDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Dh();
    }

    public final void Eh(n viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.timeLineViewModel = viewModel;
    }

    public final void Fh(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (fragmentManager.findFragmentByTag("QZAlbumxTimeLineBaseDialogFragment") == null) {
            show(fragmentManager, "QZAlbumxTimeLineBaseDialogFragment");
        }
    }

    protected final void Gh(View view, Class<?> iocClass) {
        RFWIocAbilityProvider.g().unregisterSingleIoc(view, iocClass);
    }

    public final void Hh(List<CommonStTimeLineEvent> datas, CommonStTimeLineEvent curTimeLineEvent) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        if (datas.isEmpty()) {
            return;
        }
        this.dataList.clear();
        this.dataList.addAll(wh(datas, curTimeLineEvent));
        rh();
        b bVar = this.timelineAdapter;
        if (bVar == null) {
            return;
        }
        bVar.setItems(this.dataList);
    }

    @Override // hb.j
    /* renamed from: J, reason: from getter */
    public n getTimeLineViewModel() {
        return this.timeLineViewModel;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, R.style.f246388r);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(getContentLayoutId(), (ViewGroup) null, false);
        this.rootView = inflate;
        initView(inflate);
        yh();
        initData();
        return this.rootView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Gh(this.rootView, j.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        registerDaTongReportPageId();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -1);
    }

    public final void registerDaTongReportPageId() {
        if (this.rootView == null) {
            QLog.i("QZAlbumxTimeLineBaseDialogFragment", 1, "reportDaTongRegister  rootView == null");
            return;
        }
        n nVar = this.timeLineViewModel;
        bs bsVar = nVar instanceof bs ? (bs) nVar : null;
        if (bsVar == null) {
            QLog.i("QZAlbumxTimeLineBaseDialogFragment", 1, "viewModel == null");
            return;
        }
        String uh5 = uh(bsVar);
        Map<String, Object> vh5 = vh(bsVar, uh5);
        VideoReport.setPageId(this.rootView, uh5);
        VideoReport.setPageParams(this.rootView, new fo.a().d("QZAlbumxTimeLineBaseDialogFragment", vh5));
        QLog.i("QZAlbumxTimeLineBaseDialogFragment", 1, "registerDaTongReportPageId  | appKey: 0AND0MWZXR4U3RVU | subPage: QZAlbumxTimeLineBaseDialogFragment | pageId: " + uh5);
    }

    protected final void registerIoc(View view, Object iocBaseInterface, Class<?> iocClass) {
        RFWIocAbilityProvider.g().registerIoc(view, iocBaseInterface, iocClass);
    }

    public final void Ch(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            return;
        }
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("QZAlbumxTimeLineBaseDialogFragment");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
        if (findFragmentByTag != null) {
            beginTransaction.remove(this);
            beginTransaction.commit();
        }
    }

    private final void initView(View view) {
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.nh9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.timeline_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        View view2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setItemAnimator(null);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setPadding(0, xh(), 0, 0);
        View findViewById2 = view.findViewById(R.id.f192153);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.blank_view)");
        this.blankView = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
        } else {
            view2 = findViewById2;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: gb.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QZAlbumxTimeLineBaseDialogFragment.Bh(QZAlbumxTimeLineBaseDialogFragment.this, view3);
            }
        });
    }
}
