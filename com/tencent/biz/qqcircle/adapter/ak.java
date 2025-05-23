package com.tencent.biz.qqcircle.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSPrivateSettingBean;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSimpleView;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.Switch;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ak extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<QFSPrivateSettingBean> f82628m = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements QFSSettingSwitchView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSPrivateSettingBean f82629a;

        a(QFSPrivateSettingBean qFSPrivateSettingBean) {
            this.f82629a = qFSPrivateSettingBean;
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            this.f82629a.setChecked(z16);
            if (this.f82629a.getListener() != null) {
                this.f82629a.getListener().onCheckedChanged(compoundButton, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSSettingSwitchView> f82631a;

        /* renamed from: b, reason: collision with root package name */
        private String f82632b;

        /* renamed from: c, reason: collision with root package name */
        private int f82633c = -1;

        public b(QFSSettingSwitchView qFSSettingSwitchView, String str) {
            this.f82631a = new WeakReference<>(qFSSettingSwitchView);
            this.f82632b = str;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            QFSSettingSwitchView qFSSettingSwitchView = this.f82631a.get();
            if (qFSSettingSwitchView != null) {
                buildElementParams.put(this.f82632b, Integer.valueOf(qFSSettingSwitchView.F0() ? 1 : 0));
            }
            return buildElementParams;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ViewHolder {
        private final QFSSettingSimpleView E;

        public c(QFSSettingSimpleView qFSSettingSimpleView) {
            super(qFSSettingSimpleView);
            this.E = qFSSettingSimpleView;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d extends RecyclerView.ViewHolder {
        private final QFSSettingSwitchView E;

        public d(QFSSettingSwitchView qFSSettingSwitchView) {
            super(qFSSettingSwitchView);
            this.E = qFSSettingSwitchView;
        }
    }

    private void j0(QFSSettingSwitchView qFSSettingSwitchView, String str) {
        VideoReport.setElementId(qFSSettingSwitchView.D0(), str);
        VideoReport.setEventDynamicParams(qFSSettingSwitchView.D0(), new b(qFSSettingSwitchView, QCircleDaTongConstant.ElementParamKey.XSJ_PRIVACY_SETTING_BUTTON_STATE));
        VideoReport.setElementExposePolicy(qFSSettingSwitchView.D0(), ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(qFSSettingSwitchView.D0(), ClickPolicy.REPORT_ALL);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f82628m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f82628m.get(i3).getViewType();
    }

    public ArrayList<QFSPrivateSettingBean> i0() {
        return this.f82628m;
    }

    public void k0(ArrayList<QFSPrivateSettingBean> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f82628m.clear();
        if (arrayList.size() > 0) {
            this.f82628m.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void l0(String str, boolean z16) {
        ArrayList<QFSPrivateSettingBean> arrayList = this.f82628m;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < this.f82628m.size(); i3++) {
                QFSPrivateSettingBean qFSPrivateSettingBean = this.f82628m.get(i3);
                if (qFSPrivateSettingBean != null && TextUtils.equals(qFSPrivateSettingBean.getKey(), str) && qFSPrivateSettingBean.isChecked() != z16) {
                    qFSPrivateSettingBean.setChecked(z16);
                    notifyItemChanged(i3);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        QFSPrivateSettingBean qFSPrivateSettingBean = this.f82628m.get(i3);
        if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            dVar.E.setBgType(qFSPrivateSettingBean.getBgType());
            dVar.E.setTitle(qFSPrivateSettingBean.getTitle());
            dVar.E.setHide(qFSPrivateSettingBean.getHide());
            dVar.E.setHead(qFSPrivateSettingBean.getHead());
            dVar.E.setLeftIcon(qFSPrivateSettingBean.getDrawableId());
            dVar.E.setListener(new a(qFSPrivateSettingBean));
            dVar.E.setCheckedOnly(qFSPrivateSettingBean.isChecked());
            j0(dVar.E, qFSPrivateSettingBean.getEid());
            return;
        }
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            cVar.E.setBgType(qFSPrivateSettingBean.getBgType());
            cVar.E.setTitle(qFSPrivateSettingBean.getLeftText());
            cVar.E.setHint(qFSPrivateSettingBean.getHide());
            cVar.E.setRightText(qFSPrivateSettingBean.getRightText());
            cVar.E.setLeftIcon(qFSPrivateSettingBean.getDrawableId());
            cVar.E.setClickListener(qFSPrivateSettingBean.getOnClickListener());
            cVar.E.setIsNeedGap(qFSPrivateSettingBean.getIsNeedGap());
            cVar.E.b(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 != 2) {
            return new d(new QFSSettingSwitchView(viewGroup.getContext()));
        }
        return new c(new QFSSettingSimpleView(viewGroup.getContext()));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:57:0x010e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0029. Please report as an issue. */
    public void updateData(List<Integer> list) {
        for (int i3 = 0; i3 < this.f82628m.size(); i3++) {
            QFSPrivateSettingBean qFSPrivateSettingBean = this.f82628m.get(i3);
            String key = qFSPrivateSettingBean.getKey();
            key.hashCode();
            boolean z16 = true;
            char c16 = '\uffff';
            switch (key.hashCode()) {
                case -1912856166:
                    if (key.equals(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_RECOM_LIKE_FEED_TO_FRIENDS)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -1578806560:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_NEW_MSG)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -1401952559:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ALLOW_GAME_PAGE_ENTRANCE)) {
                        c16 = 2;
                        break;
                    }
                    break;
                case -1361916871:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PUSHED)) {
                        c16 = 3;
                        break;
                    }
                    break;
                case -428735508:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_VIDEO_VOICE)) {
                        c16 = 4;
                        break;
                    }
                    break;
                case -319628636:
                    if (key.equals(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_VISITOR_SWITCH)) {
                        c16 = 5;
                        break;
                    }
                    break;
                case -106641790:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ENABLE_AI_COMMENT)) {
                        c16 = 6;
                        break;
                    }
                    break;
                case 620652642:
                    if (key.equals(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_CONTRACT_SWITCH)) {
                        c16 = 7;
                        break;
                    }
                    break;
                case 627782504:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRAISED)) {
                        c16 = '\b';
                        break;
                    }
                    break;
                case 880966675:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_FAN)) {
                        c16 = '\t';
                        break;
                    }
                    break;
                case 1172137553:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRESENTATION_MFO)) {
                        c16 = '\n';
                        break;
                    }
                    break;
                case 1172139473:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRESENTATION_OFM)) {
                        c16 = 11;
                        break;
                    }
                    break;
                case 1271157943:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ENABLE_PERSONAL_RECOMMEND)) {
                        c16 = '\f';
                        break;
                    }
                    break;
                case 1401684634:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ONE_KEY_DEFEND)) {
                        c16 = '\r';
                        break;
                    }
                    break;
                case 1540074000:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_CARD)) {
                        c16 = 14;
                        break;
                    }
                    break;
                case 1899483690:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_COLLECT)) {
                        c16 = 15;
                        break;
                    }
                    break;
                case 1952740313:
                    if (key.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_REC_PIC)) {
                        c16 = 16;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    z16 = list.contains(27);
                    break;
                case 1:
                    z16 = QCirclePluginUtil.canSyncTroopARK(list);
                    break;
                case 2:
                    z16 = list.contains(25);
                    break;
                case 3:
                    z16 = com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.a(list, 8);
                    break;
                case 4:
                    z16 = QCircleHostConfig.getQQCircleAllowExtractVideoMusic();
                    break;
                case 5:
                    z16 = list.contains(28);
                    break;
                case 6:
                    z16 = uq3.c.H0();
                    break;
                case 7:
                    z16 = list.contains(29);
                    break;
                case '\b':
                    z16 = com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.a(list, 6);
                    break;
                case '\t':
                    z16 = com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.a(list, 9);
                    break;
                case '\n':
                    z16 = list.contains(23);
                    break;
                case 11:
                    z16 = list.contains(33);
                    break;
                case '\f':
                    z16 = com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.a(list, 10);
                    break;
                case '\r':
                    z16 = com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a.e(Switch.PROTECTION.name());
                    break;
                case 14:
                    z16 = QCirclePluginUtil.canJumpToQQProfile(list);
                    break;
                case 15:
                    z16 = com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.a(list, 19);
                    break;
                case 16:
                    z16 = uq3.k.a().c(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_REC_PIC, false);
                    break;
            }
            if (qFSPrivateSettingBean.isChecked() != z16) {
                qFSPrivateSettingBean.setChecked(z16);
                notifyItemChanged(i3);
            }
        }
    }
}
