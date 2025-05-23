package com.tencent.mobileqq.activity.aio.intimate.header;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.IQZoneIntimateSpaceApi;
import java.util.HashMap;
import java.util.Iterator;
import qzone.QZIntimateSpaceRedDotReader$EntranceInfo;
import qzone.QZoneBaseCommon$Entry;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QZoneIntimateSpaceEntranceView extends BaseWidgetView<QZIntimateSpaceRedDotReader$EntranceInfo> implements View.OnClickListener, View.OnTouchListener {
    private final int C;
    private ViewGroup D;
    private TextView E;
    private TextView F;
    private View G;
    private View H;
    private int I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    private final int f179003d;

    /* renamed from: e, reason: collision with root package name */
    private final int f179004e;

    /* renamed from: f, reason: collision with root package name */
    private final int f179005f;

    /* renamed from: h, reason: collision with root package name */
    private final int f179006h;

    /* renamed from: i, reason: collision with root package name */
    private final int f179007i;

    /* renamed from: m, reason: collision with root package name */
    private final int f179008m;

    public QZoneIntimateSpaceEntranceView(@NonNull Context context) {
        super(context);
        this.f179003d = ViewUtils.dpToPx(2.0f);
        this.f179004e = ViewUtils.dpToPx(4.0f);
        this.f179005f = ViewUtils.dpToPx(6.0f);
        this.f179006h = ViewUtils.dpToPx(8.0f);
        this.f179007i = ViewUtils.dpToPx(12.0f);
        this.f179008m = ViewUtils.dpToPx(14.0f);
        this.C = ViewUtils.dpToPx(16.0f);
        this.I = -1;
    }

    private void initView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f68723gt);
        this.D = viewGroup;
        viewGroup.setOnTouchListener(this);
        this.D.setOnClickListener(this);
        this.H = findViewById(R.id.y8_);
        this.E = (TextView) findViewById(R.id.f68703gr);
        this.F = (TextView) findViewById(R.id.f68713gs);
        this.G = findViewById(R.id.f68693gq);
    }

    private HashMap<String, Object> m0() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("close_friend_space_type", Integer.valueOf(this.I));
        QZIntimateSpaceRedDotReader$EntranceInfo data = getData();
        if (data != null) {
            hashMap.put("close_friend_space_id", data.space_id.get());
            Iterator<QZoneBaseCommon$Entry> it = data.entry.get().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                QZoneBaseCommon$Entry next = it.next();
                if (next != null && TextUtils.equals(next.key.get(), "entry_state")) {
                    hashMap.put("entry_state", Integer.valueOf(data.status.get()));
                    break;
                }
            }
        } else {
            QLog.e("QZoneIntimateSpaceEntranceView", 1, "[getDtElementParams] entranceInfo is null");
        }
        return hashMap;
    }

    private void n0() {
        if (getData() == null) {
            QLog.e("QZoneIntimateSpaceEntranceView", 1, "[handleEntranceClick] data == null");
            return;
        }
        String str = getData().url.get();
        QLog.d("QZoneIntimateSpaceEntranceView", 1, "[handleEntranceClick] url = " + str);
        ((IQZoneIntimateSpaceApi) QRoute.api(IQZoneIntimateSpaceApi.class)).handleScheme(str, getContext(), null);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_qz_chum_space_entry", null, m0());
    }

    private boolean o0(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 26) {
            return true;
        }
        return false;
    }

    private boolean p0(QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo) {
        if (qZIntimateSpaceRedDotReader$EntranceInfo == null) {
            QLog.e("QZoneIntimateSpaceEntranceView", 1, "[doUpdateQZoneIntimateSpaceInfo] entranceInfo is null");
            return true;
        }
        if (!qZIntimateSpaceRedDotReader$EntranceInfo.has() || qZIntimateSpaceRedDotReader$EntranceInfo.status.get() == 0) {
            return true;
        }
        if (!o0(this.I) && !q0()) {
            return true;
        }
        return false;
    }

    private boolean q0() {
        return ((IQZoneIntimateSpaceApi) QRoute.api(IQZoneIntimateSpaceApi.class)).isPartnerSpaceEntranceSwitchOpen();
    }

    private void s0() {
        if (this.J) {
            ColorStateList valueOf = ColorStateList.valueOf(IntimateHeaderCardUtil.s(this.I));
            int i3 = this.f179005f;
            this.D.setBackground(ViewUtils.customRadiusDrawable(valueOf, i3, i3, i3, i3));
            ViewGroup viewGroup = this.D;
            int i16 = this.f179005f;
            viewGroup.setPadding(i16, i16, this.f179003d, i16);
            View view = this.H;
            int i17 = this.f179008m;
            ViewUtils.setViewSize(view, i17, i17);
            return;
        }
        ViewUtils.updateLPHeight(this.D, ViewUtils.dpToPx(29.0f));
        ViewUtils.setMarginTop(this.D, ViewUtils.dpToPx(10.0f));
        this.D.setPadding(this.f179007i, 0, 0, this.f179005f);
        this.D.setBackground(getResources().getDrawable(R.drawable.f160885ju4));
        u0(this.I);
        View view2 = this.H;
        int i18 = this.C;
        ViewUtils.setViewSize(view2, i18, i18);
    }

    private void u0(int i3) {
        if (!QQTheme.isVasTheme()) {
            IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
            if (intimateHeaderCardUtil.r().containsKey(Integer.valueOf(i3))) {
                this.D.setBackgroundResource(intimateHeaderCardUtil.r().get(Integer.valueOf(i3)).intValue());
            }
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f169016hl3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo, int i3) {
        if (this.I == -1) {
            if (QLog.isColorLevel()) {
                QLog.e("QZoneIntimateSpaceEntranceView", 2, "[bindData] mIntimate is null, hashCode = " + hashCode());
                return;
            }
            return;
        }
        l0();
    }

    public void l0() {
        String str;
        String str2;
        String str3;
        QZIntimateSpaceRedDotReader$EntranceInfo data = getData();
        int i3 = 8;
        if (data == null) {
            QLog.e("QZoneIntimateSpaceEntranceView", 1, "[doUpdateQZoneIntimateSpaceInfo] entranceInfo is null");
            setVisibility(8);
            return;
        }
        if (p0(data)) {
            if (this.J) {
                setVisibility(4);
                return;
            } else {
                setVisibility(8);
                return;
            }
        }
        setVisibility(0);
        String[] split = data.guide.get().split("\\|");
        String str4 = "";
        if (split.length <= 0 || (str3 = split[0]) == null) {
            str = "";
        } else {
            str = str3.trim();
        }
        if (split.length > 1 && (str2 = split[1]) != null) {
            str4 = str2.trim();
        }
        s0();
        View view = this.G;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str4)) {
            i3 = 0;
        }
        view.setVisibility(i3);
        this.E.setText(str);
        this.F.setText(str4);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_qz_chum_space_entry", null, m0());
        QLog.i("QZoneIntimateSpaceEntranceView", 1, "tryShowChatDrawerGuideBubbleTip, needFetchTianShu " + (!TextUtils.isEmpty(data.space_id.get())));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.f68723gt) {
            n0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r0();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        }
        view.setAlpha(0.5f);
        return false;
    }

    public void r0() {
        ((IQZoneIntimateSpaceApi) QRoute.api(IQZoneIntimateSpaceApi.class)).dispatchDestroyIntimateBubbleEvent();
    }

    public void setIntimateHeaderType(int i3) {
        this.I = i3;
        if (getData() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("QZoneIntimateSpaceEntranceView", 2, "[setIntimateHeaderType] entrance info is null, intimateType = " + this.I + ", hashCode = " + hashCode());
                return;
            }
            return;
        }
        l0();
    }

    public void setUse8996UI(boolean z16) {
        this.J = z16;
    }

    public QZoneIntimateSpaceEntranceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f179003d = ViewUtils.dpToPx(2.0f);
        this.f179004e = ViewUtils.dpToPx(4.0f);
        this.f179005f = ViewUtils.dpToPx(6.0f);
        this.f179006h = ViewUtils.dpToPx(8.0f);
        this.f179007i = ViewUtils.dpToPx(12.0f);
        this.f179008m = ViewUtils.dpToPx(14.0f);
        this.C = ViewUtils.dpToPx(16.0f);
        this.I = -1;
        initView();
    }

    public QZoneIntimateSpaceEntranceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f179003d = ViewUtils.dpToPx(2.0f);
        this.f179004e = ViewUtils.dpToPx(4.0f);
        this.f179005f = ViewUtils.dpToPx(6.0f);
        this.f179006h = ViewUtils.dpToPx(8.0f);
        this.f179007i = ViewUtils.dpToPx(12.0f);
        this.f179008m = ViewUtils.dpToPx(14.0f);
        this.C = ViewUtils.dpToPx(16.0f);
        this.I = -1;
        initView();
    }
}
