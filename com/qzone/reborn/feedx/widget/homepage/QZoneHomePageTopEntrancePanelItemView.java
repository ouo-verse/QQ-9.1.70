package com.qzone.reborn.feedx.widget.homepage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.homepage.ui.component.newpanel.HomePanelItem;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes37.dex */
public abstract class QZoneHomePageTopEntrancePanelItemView extends QZoneBaseWidgetView<HomePanelItem> implements View.OnClickListener {
    protected QZoneUserAvatarView C;
    protected String D;
    protected boolean E;
    protected x6.a F;

    /* renamed from: e, reason: collision with root package name */
    protected ViewGroup f56383e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f56384f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f56385h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f56386i;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f56387m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements IDynamicParams {
        a() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            HashMap hashMap = new HashMap();
            QZoneHomePageTopEntrancePanelItemView qZoneHomePageTopEntrancePanelItemView = QZoneHomePageTopEntrancePanelItemView.this;
            if (!qZoneHomePageTopEntrancePanelItemView.E) {
                qZoneHomePageTopEntrancePanelItemView.E = qZoneHomePageTopEntrancePanelItemView.u0();
            }
            if (QZoneHomePageTopEntrancePanelItemView.this.E) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put("is_friend_profile_picture", str2);
            QZoneHomePageTopEntrancePanelItemView.this.E = false;
            return hashMap;
        }
    }

    public QZoneHomePageTopEntrancePanelItemView(Context context) {
        super(context);
    }

    private void o0() {
        TextView textView;
        if (this.C == null || (textView = this.f56386i) == null) {
            return;
        }
        textView.setVisibility(0);
        this.C.setVisibility(8);
    }

    private void q0(HomePanelItem homePanelItem) {
        HashMap hashMap = new HashMap();
        Map<String, String> map = homePanelItem.extInfo;
        if (map != null && map.containsKey("entry_state")) {
            hashMap.put("entry_state", homePanelItem.extInfo.get("entry_state"));
        }
        fo.c.o(this.f56383e, "em_bas_chum_space_entry", new fo.b().i("tab_id=" + homePanelItem.tabId).l(hashMap).h(new a()));
    }

    private void s0() {
        if (com.qzone.reborn.util.e.b("QZoneHomePageTopEntrancePanelItemViewHalfScreen", 500L)) {
            return;
        }
        HomePanelItem data = getData();
        if (data != null && !TextUtils.isEmpty(data.jumpUrl)) {
            if (getContext() == null) {
                QLog.e("QZoneHomePageTopEntrancePanelItemView", 1, "[handleEntranceItemClick] context is null");
                return;
            }
            this.E = u0();
            this.D = "";
            o0();
            QLog.d("QZoneHomePageTopEntrancePanelItemView", 1, "[handleEntranceItemClick] jump_url = " + data.jumpUrl);
            yo.d.d(data.jumpUrl, getContext(), null);
            return;
        }
        QLog.e("QZoneHomePageTopEntrancePanelItemView", 1, "[handleEntranceItemClick] itemInfo or jump_url is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u0() {
        return !TextUtils.isEmpty(this.D);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.coe;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getViewType() {
        return r0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.f162828mu4) {
            s0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public abstract void onDestroy();

    public abstract int r0();

    public void v0(int i3) {
        QLog.i("QZoneHomePageTopEntrancePanelItemView", 1, "updateColor: " + i3);
        if (i3 != 0) {
            this.f56385h.setTextColor(i3);
            this.f56386i.setTextColor(i3);
            com.tencent.mobileqq.qzone.picload.c.a().m(this.f56384f, i3);
        } else {
            this.f56385h.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
            this.f56386i.setTextColor(getContext().getColor(R.color.qui_common_text_secondary));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w0(HomePanelItem homePanelItem) {
        this.f56385h.setText(homePanelItem.text);
        this.f56386i.setText(homePanelItem.rightText);
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(mk.c.f416874a.b(homePanelItem.iconUrl)).setTargetView(this.f56384f).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans));
        q0(homePanelItem);
    }

    public void y0(x6.a aVar) {
        this.F = aVar;
    }

    public void x0(boolean z16) {
        if (z16) {
            p0();
        }
    }

    public void initView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f162828mu4);
        this.f56383e = viewGroup;
        viewGroup.setOnClickListener(this);
        this.f56384f = (ImageView) findViewById(R.id.mu6);
        this.f56385h = (TextView) findViewById(R.id.mu7);
        this.f56386i = (TextView) findViewById(R.id.mu5);
        this.f56387m = (ImageView) findViewById(R.id.mu8);
        this.C = (QZoneUserAvatarView) findViewById(R.id.f162827mu3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(HomePanelItem homePanelItem, int i3) {
        if (homePanelItem == null) {
            QLog.e("QZoneHomePageTopEntrancePanelItemView", 1, "[bindData] data == null");
        } else {
            w0(homePanelItem);
        }
    }

    protected void p0() {
    }
}
