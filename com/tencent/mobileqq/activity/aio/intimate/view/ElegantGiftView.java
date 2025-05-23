package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ElegantGiftView extends IntimateContentItemBaseView {
    private TextView F;
    private a G;
    private int H;
    private int I;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<String> f179209d;

        /* renamed from: e, reason: collision with root package name */
        private int f179210e = 4;

        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f179209d == null) {
                return 0;
            }
            int screenWidth = ((ViewUtils.getScreenWidth() - ViewUtils.dip2px(40.0f)) - ElegantGiftView.this.I) / (ViewUtils.dip2px(72.0f) + ElegantGiftView.this.I);
            if (screenWidth > 0 && screenWidth <= this.f179210e) {
                this.f179210e = screenWidth;
            }
            return Math.min(this.f179209d.size(), this.f179210e);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            if (this.f179209d.size() > i3) {
                this.f179209d.get(i3);
                return null;
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        @RequiresApi(api = 16)
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ElegantGiftView.this.f179219d).inflate(R.layout.fd5, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.f165292co2);
            String str = this.f179209d.get(i3);
            if (!TextUtils.isEmpty(str)) {
                try {
                    URLDrawable drawable = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null);
                    drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306345y);
                    imageView.setImageDrawable(drawable);
                } catch (Exception e16) {
                    QLog.e("intimate_relationship", 1, String.format("Url for friend gift:" + str, e16));
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        public void setData(List<String> list) {
            this.f179209d = list;
            if (list == null) {
                this.f179209d = new ArrayList();
            }
            notifyDataSetChanged();
        }
    }

    public ElegantGiftView(Context context) {
        this(context, null);
    }

    private void t() {
        IntimateInfo.FriendGiftInfo friendGiftInfo;
        IntimateInfo intimateInfo = this.f179223i;
        if (intimateInfo != null && (friendGiftInfo = intimateInfo.friendGiftInfo) != null && friendGiftInfo.str_gift_url != null && friendGiftInfo.str_send_times > 0) {
            setVisibility(0);
            this.F.setText(String.valueOf(this.f179223i.friendGiftInfo.str_send_times));
            if (this.f179223i.friendGiftInfo.str_gift_url.size() > 6) {
                this.G.setData(this.f179223i.friendGiftInfo.str_gift_url.subList(0, 6));
                return;
            } else {
                this.G.setData(this.f179223i.friendGiftInfo.str_gift_url);
                return;
            }
        }
        setVisibility(8);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        return ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        View inflate = LayoutInflater.from(this.f179219d).inflate(R.layout.fcv, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.liq);
        this.F = (TextView) inflate.findViewById(R.id.lir);
        HorizontalListView horizontalListView = (HorizontalListView) inflate.findViewById(R.id.liu);
        this.G = new a();
        horizontalListView.setDividerWidth(this.I);
        horizontalListView.setAdapter((ListAdapter) this.G);
        findViewById.setOnClickListener(this);
        horizontalListView.setOnTouchListener(this);
        horizontalListView.setTransTouchStateToParent(true);
        findViewById.setOnTouchListener(this);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(View view) {
        if (view.getId() != R.id.liq || this.f179219d == null) {
            return;
        }
        Intent intent = new Intent(this.f179219d, (Class<?>) QQBrowserActivity.class);
        String str = this.f179223i.friendGiftInfo.str_custom_url;
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("goToFriendGiftWebPage, url: %s", str));
        }
        intent.putExtra("url", str);
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_OUT_TO_RIGHT, true);
        intent.putExtra(QQBrowserActivity.IS_WRAP_CONTENT, true);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        this.f179219d.startActivity(intent);
        ReportController.o(null, "dc00898", "", "", "0X800A3B4", "0X800A3B4", this.H, 0, "", "", "", "");
        MobileReportManager.getInstance().reportAction("gift_record", "4", "qzonevip_gift", "aio_zuohua", "qq_gift", 102, 0, System.currentTimeMillis());
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_bas_gift_entry", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), null);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(IntimateInfo intimateInfo, int i3) {
        boolean z16;
        List<IntimateInfo.CommonBody> list;
        if (intimateInfo != null && (list = intimateInfo.commonBodyList) != null && list.size() > 0) {
            for (IntimateInfo.CommonBody commonBody : intimateInfo.commonBodyList) {
                if (commonBody.cmd == 3436) {
                    IntimateInfo.FriendGiftInfo copyFrom = IntimateInfo.FriendGiftInfo.copyFrom(commonBody);
                    intimateInfo.friendGiftInfo = copyFrom;
                    if (copyFrom != null && copyFrom.str_send_times > 0) {
                        z16 = true;
                        break;
                    }
                }
            }
        }
        z16 = false;
        if (z16) {
            t();
        } else {
            setVisibility(8);
        }
    }

    public void setReportType(int i3) {
        this.H = i3;
    }

    public ElegantGiftView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ElegantGiftView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = 1;
        this.I = ViewUtils.dip2px(16.0f);
    }
}
