package com.qzone.reborn.layer.part;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.reborn.layer.share.QZoneShareLongPicAction;
import com.qzone.reborn.layer.share.QZoneShareLongPicToWXFriendAction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class be extends QZoneFeedxLayerSharePart {

    /* renamed from: d0, reason: collision with root package name */
    private RecyclerView f57998d0;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            be.this.w1();
            tk.h.S(20L);
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "6", "", true);
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Aa(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new com.qzone.reborn.layer.share.o(getActivity()).t(ta(), actionSheetItem);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Ba(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new com.qzone.reborn.layer.share.p(getActivity()).t(ta(), actionSheetItem);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Fa(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new QZoneShareLongPicToWXFriendAction(getActivity()).t(ta(), actionSheetItem);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean Ka() {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Ta() {
        if (this.f57984d != null) {
            this.f57998d0.setOnLongClickListener(new a());
        } else {
            this.f57998d0.setOnClickListener(null);
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean Z9(IOCRService iOCRService, String str) {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean da() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    public com.qzone.reborn.layer.share.f ta() {
        com.qzone.reborn.layer.share.f ta5 = super.ta();
        uk.f fVar = (uk.f) getViewModel(uk.f.class);
        if (fVar == null) {
            return ta5;
        }
        ta5.f58181e = new ArrayList<>(fVar.U1());
        return ta5;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void za(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new QZoneShareLongPicAction(getActivity()).t(ta(), actionSheetItem);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void ra(View view) {
        if (view == null) {
            return;
        }
        this.f57998d0 = (RecyclerView) view.findViewById(R.id.neg);
    }
}
