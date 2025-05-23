package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.TopAlignSuperscriptSpan;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.util.w;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.RoundRectImageView;
import f61.i;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class IntimateContentItemNewDnaView extends IntimateContentItemBaseView {
    private RecyclerView F;
    private c G;
    private d H;
    private boolean I;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements d {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView.d
        public void a(View view, int i3, i iVar) {
            if (iVar != null && !TextUtils.isEmpty(iVar.f397931c)) {
                IntimateContentItemNewDnaView.this.B(iVar);
            } else if (iVar != null && iVar.f397929a == 23) {
                IntimateContentItemNewDnaView.this.C(iVar);
            } else if (iVar != null && !TextUtils.isEmpty(iVar.f397934f)) {
                IntimateContentItemNewDnaView.this.A(iVar);
            }
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_bas_friend_dna", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends GridLayoutManager {
        b(Context context, int i3) {
            super(context, i3);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: m, reason: collision with root package name */
        private List<i> f179230m = new ArrayList();

        c() {
        }

        private void i0(LinearLayout linearLayout, ArrayList<i.a> arrayList) {
            if (linearLayout != null && arrayList != null && arrayList.size() > 0) {
                linearLayout.removeAllViews();
                for (int i3 = 0; i3 < arrayList.size() && i3 < 2; i3++) {
                    i.a aVar = arrayList.get(i3);
                    TextView textView = new TextView(IntimateContentItemNewDnaView.this.f179219d);
                    textView.setTextSize(1, 22.0f);
                    textView.setSingleLine(true);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setTextColor(ContextCompat.getColorStateList(IntimateContentItemNewDnaView.this.f179219d, R.color.qui_common_text_primary));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(0, ViewUtils.dpToPx(2.0f), 0, 0);
                    textView.setLayoutParams(layoutParams);
                    SpannableString j06 = j0(aVar.f397935a, aVar.f397936b, aVar.f397937c);
                    if (j06 != null) {
                        textView.setText(j06);
                    }
                    linearLayout.addView(textView);
                }
            }
        }

        private SpannableString j0(String str, int i3, int i16) {
            try {
                SpannableString spannableString = new SpannableString(str);
                byte[] bArr = new byte[i16];
                System.arraycopy(str.getBytes(), i3, bArr, 0, i16);
                String str2 = new String(bArr);
                int indexOf = str.indexOf(str2);
                int length = str2.length();
                if (TextUtils.equals(str, str2) && str.length() == str2.length()) {
                    SpannableString spannableString2 = new SpannableString(str);
                    spannableString2.setSpan(new StyleSpan(0), 0, str.length(), 33);
                    spannableString2.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(17.0f)), 0, str.length(), 33);
                    return spannableString2;
                }
                int i17 = length + indexOf;
                int length2 = str.length() - i17;
                int i18 = indexOf + 0;
                spannableString.setSpan(new StyleSpan(0), 0, i18, 33);
                spannableString.setSpan(new TopAlignSuperscriptSpan(0.3f), 0, i18, 33);
                spannableString.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(10.0f)), 0, i18, 33);
                int i19 = length2 + i17;
                spannableString.setSpan(new StyleSpan(0), i17, i19, 33);
                spannableString.setSpan(new TopAlignSuperscriptSpan(0.3f), i17, i19, 33);
                spannableString.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(10.0f)), i17, i19, 33);
                return spannableString;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("IntimateContentItemNewDnaView", 2, "getSpecialContent fail:" + e16.toString());
                    return null;
                }
                return null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.f179230m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
            e eVar = (e) viewHolder;
            i iVar = this.f179230m.get(i3);
            ReportController.o(null, "dc00898", "", "", "0X800B568", "0X800B568", iVar.f397929a, 0, "", "", "", "");
            eVar.itemView.setTag(iVar);
            if (!TextUtils.isEmpty(iVar.f397930b)) {
                eVar.F.setText(iVar.f397930b);
            }
            ArrayList<i.a> arrayList = iVar.f397932d;
            if (arrayList != null && arrayList.size() > 0) {
                i0(eVar.G, iVar.f397932d);
            } else {
                eVar.G.removeAllViews();
            }
            eVar.H.setCornerRadiusAndMode(ViewUtils.dpToPx(15.0f), 1);
            eVar.H.setVisibility(8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            IntimateContentItemNewDnaView intimateContentItemNewDnaView = IntimateContentItemNewDnaView.this;
            return new e(LayoutInflater.from(intimateContentItemNewDnaView.f179219d).inflate(R.layout.f168213fd3, (ViewGroup) null));
        }

        public void setData(List<i> list) {
            if (list != null && list.size() > 0) {
                this.f179230m.clear();
                this.f179230m.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private interface d {
        void a(View view, int i3, i iVar);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class e extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnTouchListener {
        public RelativeLayout E;
        public TextView F;
        public LinearLayout G;
        public RoundRectImageView H;

        public e(@NonNull View view) {
            super(view);
            this.E = (RelativeLayout) view.findViewById(R.id.f165848xt2);
            this.F = (TextView) view.findViewById(R.id.vez);
            this.G = (LinearLayout) view.findViewById(R.id.vex);
            this.H = (RoundRectImageView) view.findViewById(R.id.xt5);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (IntimateContentItemNewDnaView.this.F != null) {
                IntimateContentItemNewDnaView.this.H.a(view, getLayoutPosition(), (i) this.itemView.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
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
    }

    public IntimateContentItemNewDnaView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(i iVar) {
        ReportController.o(null, "dc00898", "", "", "0X800B569", "0X800B569", iVar.f397929a, 0, "", "", "", "");
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this.f179219d, iVar.f397934f, 2064, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(i iVar) {
        if (w.a(1000L)) {
            ReportController.o(null, "dc00898", "", "", "0X800B569", "0X800B569", iVar.f397929a, 0, "", "", "", "");
            Intent intent = new Intent(this.f179219d, (Class<?>) QQTranslucentBrowserActivity.class);
            intent.putExtra("url", iVar.f397931c);
            intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, true);
            intent.putExtra(QQTranslucentBrowserActivity.FLAG_HIDE_FLOAT_BAR, true);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            this.f179219d.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(i iVar) {
        QQAppInterface j3;
        String str;
        if (this.f179219d != null && (j3 = j()) != null && w.a(1000L)) {
            ReportController.o(null, "dc00898", "", "", "0X800B569", "0X800B569", iVar.f397929a, 0, "", "", "", "");
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f179220e), "IntimateContentItemNewDnaView");
            int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeInt("drawer_cur_adcode", 0);
            if (decodeInt != 0) {
                str = String.valueOf(decodeInt);
            } else {
                str = "";
            }
            String str2 = str;
            if (onlineStatusSimpleInfoWithUid != null && !TextUtils.isEmpty(onlineStatusSimpleInfoWithUid.c())) {
                ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(this.f179219d, j3, new com.tencent.mobileqq.weather.util.a(false, "", false, onlineStatusSimpleInfoWithUid.c(), ""));
            } else if (!TextUtils.isEmpty(str2)) {
                ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(this.f179219d, j3, new com.tencent.mobileqq.weather.util.a(false, "", false, str2, ""));
            } else {
                D(this.f179219d.getString(R.string.f161111wu));
            }
        }
    }

    private void D(String str) {
        if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(getContext(), 1, str, 0).show();
        }
    }

    private void x(List<i> list) {
        if (list != null && list.size() > 0) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof QQAppInterface)) {
                QLog.e("IntimateContentItemNewDnaView", 1, "checkWeatherItemData fail, app is null");
                return;
            }
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f179220e), "IntimateContentItemNewDnaView");
            ArrayList arrayList = new ArrayList();
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            for (i iVar : list) {
                if (iVar.f397929a == 23) {
                    String decodeString = from.decodeString("drawer_cur_temp", null);
                    String decodeString2 = from.decodeString("drawer_cur_city", null);
                    int decodeInt = from.decodeInt("drawer_cur_adcode", 0);
                    String decodeString3 = from.decodeString("drawer_cur_desc", null);
                    if (onlineStatusSimpleInfoWithUid != null && ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).isWeatherInfoValid(onlineStatusSimpleInfoWithUid) && !TextUtils.isEmpty(onlineStatusSimpleInfoWithUid.c()) && !TextUtils.isEmpty(onlineStatusSimpleInfoWithUid.e()) && !TextUtils.isEmpty(onlineStatusSimpleInfoWithUid.f()) && !TextUtils.isEmpty(onlineStatusSimpleInfoWithUid.d0()) && !TextUtils.isEmpty(onlineStatusSimpleInfoWithUid.o0())) {
                        y(onlineStatusSimpleInfoWithUid, arrayList, iVar);
                    } else if (!TextUtils.isEmpty(decodeString) && !TextUtils.isEmpty(decodeString2) && decodeInt != 0 && !TextUtils.isEmpty(decodeString3)) {
                        z(arrayList, iVar, decodeString, decodeString2, decodeString3);
                    }
                } else {
                    arrayList.add(iVar);
                }
            }
            c cVar = this.G;
            if (cVar != null) {
                cVar.setData(arrayList);
            }
        }
    }

    private void y(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, List<i> list, i iVar) {
        i.a aVar = new i.a();
        String str = cVar.d0() + "\u00b0" + cVar.o0();
        aVar.f397935a = str;
        aVar.f397936b = 0;
        aVar.f397937c = str.getBytes().length;
        i.a aVar2 = new i.a();
        String str2 = cVar.f() + cVar.e();
        aVar2.f397935a = str2;
        aVar2.f397936b = 0;
        aVar2.f397937c = str2.getBytes().length;
        ArrayList<i.a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        ArrayList<i.a> arrayList2 = iVar.f397932d;
        if (arrayList2 != null) {
            arrayList2.clear();
            iVar.f397932d.addAll(arrayList);
        } else {
            iVar.f397932d = arrayList;
        }
        list.add(iVar);
    }

    private void z(List<i> list, i iVar, String str, String str2, String str3) {
        i.a aVar = new i.a();
        String str4 = str + "\u00b0" + str3;
        aVar.f397935a = str4;
        aVar.f397936b = 0;
        aVar.f397937c = str4.getBytes().length;
        String[] split = str2.split("-");
        if (split.length == 2) {
            str2 = split[0] + split[1];
        }
        i.a aVar2 = new i.a();
        aVar2.f397935a = str2;
        aVar2.f397936b = 0;
        aVar2.f397937c = str2.getBytes().length;
        ArrayList<i.a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        ArrayList<i.a> arrayList2 = iVar.f397932d;
        if (arrayList2 != null) {
            arrayList2.clear();
            iVar.f397932d.addAll(arrayList);
        } else {
            iVar.f397932d = arrayList;
        }
        list.add(iVar);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        boolean z16;
        ArrayList<i> arrayList;
        boolean z17 = FriendIntimateRelationshipConfProcessor.a().f202727w0;
        IntimateInfo intimateInfo = this.f179223i;
        if (intimateInfo != null && (arrayList = intimateInfo.newDnaInfos) != null && arrayList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z17 && z16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        View inflate = LayoutInflater.from(this.f179219d).inflate(R.layout.f168210fd0, (ViewGroup) this, true);
        this.F = (RecyclerView) inflate.findViewById(R.id.vey);
        this.G = new c();
        this.F.setLayoutManager(new b(this.f179219d, 2));
        this.F.setAdapter(this.G);
        if (this.I) {
            ((TextView) inflate.findViewById(R.id.f165286vf1)).setTextColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void d() {
        RecyclerView recyclerView = this.F;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(null);
            this.F.removeAllViews();
            this.F.setAdapter(null);
            this.G = null;
            this.F = null;
            removeAllViews();
        }
        super.d();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(IntimateInfo intimateInfo, int i3) {
        ArrayList<i> arrayList;
        if (intimateInfo != null && (arrayList = intimateInfo.newDnaInfos) != null && arrayList.size() > 0) {
            setVisibility(0);
            x(intimateInfo.newDnaInfos);
        } else {
            setVisibility(8);
        }
    }

    public void setIsZplanMode(Boolean bool) {
        this.I = bool.booleanValue();
    }

    public IntimateContentItemNewDnaView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IntimateContentItemNewDnaView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = new a();
        this.I = false;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(View view) {
    }
}
