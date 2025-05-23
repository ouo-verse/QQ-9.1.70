package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<Context> f75953a;

    /* renamed from: b, reason: collision with root package name */
    long f75954b;

    /* renamed from: c, reason: collision with root package name */
    int f75955c;

    /* renamed from: d, reason: collision with root package name */
    private PinnedDividerListView f75956d;

    /* renamed from: e, reason: collision with root package name */
    private d f75957e;

    /* renamed from: f, reason: collision with root package name */
    private VideoAppInterface f75958f;

    /* renamed from: g, reason: collision with root package name */
    LayoutInflater f75959g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f75961i;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<c> f75960h = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    View.OnClickListener f75962j = new a();

    /* renamed from: k, reason: collision with root package name */
    View.OnClickListener f75963k = new b();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            c cVar = (c) view.getTag();
            if (j.this.f75958f != null) {
                ReportController.o(null, "CliOper", "", "", "0X8009E26", "0X8009E26", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("GAudioMemberListCtrl", 2, "onItemClick # mRelationUinStr = " + j.this.f75954b + " # memberUin = " + String.valueOf(cVar.f75966a));
                }
                j.this.f75958f.getCurrentAccountUin();
                Intent intent = new Intent();
                intent.setAction("tencent.video.v2q.GaudioOpenTroopCard");
                intent.putExtra("troopUin", String.valueOf(j.this.f75954b));
                intent.putExtra("memberUin", String.valueOf(cVar.f75966a));
                int i16 = j.this.f75955c;
                if (i16 == 1) {
                    i3 = 1000;
                } else if (i16 == 2) {
                    i3 = 1004;
                } else {
                    i3 = 0;
                }
                intent.putExtra("uinType", i3);
                intent.setPackage(j.this.f75958f.getApplication().getPackageName());
                j.this.f75958f.getApp().sendBroadcast(intent);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            c cVar = (c) view.getTag();
            if (cVar.f75974i) {
                int i3 = j.this.f75955c;
                if (i3 == 1) {
                    ReportController.o(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
                } else if (i3 == 2) {
                    ReportController.o(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
                }
            } else {
                int i16 = j.this.f75955c;
                if (i16 == 1) {
                    ReportController.o(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
                } else if (i16 == 2) {
                    ReportController.o(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
                }
            }
            if (cVar.f75974i && cVar.f75975j) {
                QQToast.makeText(j.this.f75953a.get(), R.string.dg7, 1).show();
                if (j.this.f75955c == 1) {
                    str = "0x8007CB5";
                } else {
                    str = "0x8007CB6";
                }
                DoodleUtils.h(str);
            } else if (com.tencent.av.r.h0().b3(cVar.f75966a, !cVar.f75974i) && cVar.f75974i) {
                QQToast.makeText(j.this.f75953a.get(), R.string.vua, 1).show();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public long f75966a = 0;

        /* renamed from: b, reason: collision with root package name */
        public boolean f75967b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f75968c = false;

        /* renamed from: d, reason: collision with root package name */
        public String f75969d = null;

        /* renamed from: e, reason: collision with root package name */
        public String f75970e = null;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f75971f = null;

        /* renamed from: g, reason: collision with root package name */
        public int f75972g = 0;

        /* renamed from: h, reason: collision with root package name */
        public AVPhoneUserInfo f75973h = null;

        /* renamed from: i, reason: collision with root package name */
        public boolean f75974i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f75975j = false;

        /* renamed from: k, reason: collision with root package name */
        public boolean f75976k = true;

        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class d extends BaseAdapter {
        d() {
        }

        e a(View view, boolean z16) {
            e eVar = new e();
            eVar.f75979b = (ImageView) view.findViewById(R.id.g8k);
            eVar.f75980c = (TextView) view.findViewById(R.id.f166570g90);
            eVar.f75981d = (TextView) view.findViewById(R.id.g8m);
            eVar.f75982e = (ImageView) view.findViewById(R.id.g8_);
            eVar.f75985h = (TextView) view.findViewById(R.id.f166574g93);
            eVar.f75983f = (ImageView) view.findViewById(R.id.f166572g92);
            if (!j.this.f75961i) {
                eVar.f75982e.setVisibility(8);
                eVar.f75982e.setEnabled(false);
                eVar.f75982e.setClickable(false);
            }
            eVar.f75982e.setOnClickListener(j.this.f75963k);
            eVar.f75989l = z16;
            view.setBackgroundColor(-16777216);
            eVar.f75980c.setTextColor(Color.parseColor("#A8A8A8"));
            eVar.f75985h.setTextColor(Color.parseColor("#757575"));
            View findViewById = view.findViewById(R.id.f166573m10);
            eVar.f75984g = findViewById;
            findViewById.setBackgroundDrawable(ba.getOvalDrawable(10.4f, j.this.f75953a.get()));
            view.findViewById(R.id.acz).setBackgroundColor(Color.parseColor("#0F0F0F"));
            return eVar;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return j.this.f75960h.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return j.this.f75960h.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            e eVar;
            String str;
            View view2 = view;
            c cVar = j.this.f75960h.get(i3);
            if (view2 == null) {
                view2 = j.this.f75959g.inflate(R.layout.f168489xn, (ViewGroup) null);
                eVar = a(view2, cVar.f75976k);
                view2.setTag(eVar);
            } else {
                eVar = (e) view.getTag();
                if (eVar == null) {
                    eVar = a(view2, cVar.f75976k);
                    view2.setTag(eVar);
                }
            }
            eVar.f75982e.setTag(cVar);
            eVar.f75979b.setTag(cVar);
            if (cVar.f75969d == null || cVar.f75971f == null || !cVar.f75968c) {
                if (cVar.f75972g == 0) {
                    String valueOf = String.valueOf(cVar.f75966a);
                    String U = com.tencent.av.r.h0().U(valueOf, String.valueOf(j.this.f75954b), j.this.f75955c);
                    cVar.f75969d = U;
                    if (U != null && U.compareTo(valueOf) != 0) {
                        cVar.f75968c = true;
                    } else {
                        cVar.f75968c = false;
                    }
                    Bitmap S = com.tencent.av.r.h0().S(valueOf, String.valueOf(j.this.f75954b), j.this.f75955c, false, true);
                    if (S != null && !cVar.f75976k) {
                        S = BaseImageUtil.drawBitmapCoverLayer(S, true);
                    }
                    if (S != null) {
                        cVar.f75971f = S;
                    } else {
                        cVar.f75971f = null;
                        cVar.f75968c = false;
                    }
                } else {
                    long j3 = cVar.f75966a;
                    AVPhoneUserInfo aVPhoneUserInfo = cVar.f75973h;
                    if (aVPhoneUserInfo == null) {
                        aVPhoneUserInfo = com.tencent.av.r.h0().C(j3, com.tencent.av.n.e().f().f73061o1);
                    }
                    if (aVPhoneUserInfo != null && (str = aVPhoneUserInfo.telInfo.mobile) != null) {
                        cVar.f75969d = str;
                        String P = VideoAppInterface.N().P(aVPhoneUserInfo.telInfo.mobile);
                        if (P != null) {
                            cVar.f75970e = com.tencent.mobileqq.utils.ac.L(P);
                            cVar.f75969d = P;
                        } else {
                            cVar.f75970e = null;
                            cVar.f75969d = com.tencent.av.utils.ae.g(aVPhoneUserInfo.telInfo.mobile, 4);
                        }
                    } else {
                        if (aVPhoneUserInfo != null && QLog.isColorLevel()) {
                            QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + aVPhoneUserInfo.toString());
                        }
                        cVar.f75970e = null;
                        cVar.f75969d = j.this.f75953a.get().getResources().getString(R.string.box);
                    }
                    cVar.f75971f = ((BitmapDrawable) j.this.f75953a.get().getResources().getDrawable(R.drawable.dbo)).getBitmap();
                    cVar.f75968c = true;
                }
            }
            eVar.f75987j = true;
            long j16 = cVar.f75966a;
            eVar.f75978a = j16;
            if (cVar.f75969d != null) {
                eVar.f75980c.setText(ba.getNameMaxMaseaured(eVar.f75980c.getContext(), cVar.f75969d, eVar.f75980c, eVar.f75980c.getResources().getDimensionPixelSize(R.dimen.f158932sr)));
            } else {
                eVar.f75980c.setText(String.valueOf(j16));
            }
            if (cVar.f75971f != null) {
                if (cVar.f75972g != 0 && cVar.f75970e != null) {
                    eVar.f75981d.setVisibility(0);
                    eVar.f75981d.setText(cVar.f75970e);
                    eVar.f75979b.setImageBitmap(((BitmapDrawable) j.this.f75953a.get().getResources().getDrawable(R.drawable.day)).getBitmap());
                    if (cVar.f75969d != null) {
                        eVar.f75979b.setContentDescription(String.format(HardCodeUtil.qqStr(R.string.f1376807i), cVar.f75969d));
                    } else {
                        eVar.f75979b.setContentDescription(String.format(HardCodeUtil.qqStr(R.string.f1376807i), Long.valueOf(cVar.f75966a)));
                    }
                } else {
                    eVar.f75981d.setVisibility(8);
                    eVar.f75979b.setImageBitmap(cVar.f75971f);
                    if (cVar.f75969d != null) {
                        eVar.f75979b.setContentDescription(String.format(HardCodeUtil.qqStr(R.string.f1376807i), cVar.f75969d));
                    } else {
                        eVar.f75979b.setContentDescription(String.format(HardCodeUtil.qqStr(R.string.f1376807i), Long.valueOf(cVar.f75966a)));
                    }
                    if (cVar.f75972g == 0) {
                        eVar.f75979b.setOnClickListener(j.this.f75962j);
                    }
                }
            } else {
                eVar.f75981d.setVisibility(8);
                eVar.f75979b.setImageResource(R.drawable.f160830com);
            }
            boolean z16 = cVar.f75974i;
            if (z16) {
                int i16 = eVar.f75988k;
                if (i16 == -1 || i16 == 0) {
                    j.this.k(eVar.f75982e, z16);
                    eVar.f75988k = 1;
                }
                cVar.f75967b = false;
            } else {
                int i17 = eVar.f75988k;
                if (i17 == -1 || i17 == 1) {
                    j.this.k(eVar.f75982e, z16);
                    eVar.f75988k = 0;
                }
            }
            boolean z17 = cVar.f75967b;
            eVar.f75986i = z17;
            if (z17) {
                eVar.f75983f.setVisibility(0);
                View view3 = eVar.f75984g;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
            } else {
                eVar.f75983f.setVisibility(8);
                View view4 = eVar.f75984g;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
            }
            if (cVar.f75976k) {
                if (j.this.f75961i) {
                    eVar.f75982e.setVisibility(0);
                }
                eVar.f75985h.setVisibility(8);
            } else {
                eVar.f75985h.setVisibility(0);
                eVar.f75982e.setVisibility(8);
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        long f75978a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f75979b = null;

        /* renamed from: c, reason: collision with root package name */
        TextView f75980c = null;

        /* renamed from: d, reason: collision with root package name */
        TextView f75981d = null;

        /* renamed from: e, reason: collision with root package name */
        ImageView f75982e = null;

        /* renamed from: f, reason: collision with root package name */
        ImageView f75983f = null;

        /* renamed from: g, reason: collision with root package name */
        View f75984g = null;

        /* renamed from: h, reason: collision with root package name */
        TextView f75985h = null;

        /* renamed from: i, reason: collision with root package name */
        boolean f75986i = false;

        /* renamed from: j, reason: collision with root package name */
        boolean f75987j = true;

        /* renamed from: k, reason: collision with root package name */
        public int f75988k = -1;

        /* renamed from: l, reason: collision with root package name */
        public boolean f75989l = true;

        e() {
        }
    }

    @TargetApi(9)
    public j(Context context, VideoAppInterface videoAppInterface, PinnedDividerListView pinnedDividerListView, long j3, int i3, boolean z16) {
        this.f75957e = null;
        this.f75959g = null;
        this.f75961i = false;
        this.f75953a = new WeakReference<>(context);
        this.f75956d = pinnedDividerListView;
        this.f75954b = j3;
        this.f75955c = i3;
        this.f75958f = videoAppInterface;
        if (com.tencent.av.r.h0() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("GAudioMemberListCtrl", 2, "MVMembersContolUI-->can not get videoControl");
            }
        } else {
            this.f75959g = LayoutInflater.from(this.f75953a.get());
            d dVar = new d();
            this.f75957e = dVar;
            this.f75956d.setAdapter((ListAdapter) dVar);
            this.f75961i = z16;
        }
    }

    private int c(long j3) {
        for (int i3 = 0; i3 < this.f75960h.size(); i3++) {
            if (this.f75960h.get(i3).f75966a == j3) {
                return i3;
            }
        }
        return -1;
    }

    private void h(ArrayList<com.tencent.av.e> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource");
        }
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource-->friends list is null");
                return;
            }
            return;
        }
        this.f75960h.clear();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.tencent.av.e eVar = arrayList.get(i3);
            c cVar = new c();
            cVar.f75966a = eVar.f73701a;
            cVar.f75967b = eVar.f73703c;
            cVar.f75972g = eVar.f73715o;
            cVar.f75973h = eVar.f73716p;
            cVar.f75974i = eVar.f73717q;
            cVar.f75975j = eVar.f73718r;
            cVar.f75976k = eVar.f73724x;
            this.f75960h.add(cVar);
        }
    }

    public void d(long j3, boolean z16) {
        int c16 = c(j3);
        if (c16 == -1) {
            if (QLog.isColorLevel()) {
                QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + j3 + ",bSpeak=" + z16);
                return;
            }
            return;
        }
        c cVar = this.f75960h.get(c16);
        cVar.f75967b = z16;
        if (cVar.f75974i) {
            cVar.f75967b = false;
            z16 = false;
        }
        int firstVisiblePosition = this.f75956d.getFirstVisiblePosition();
        int lastVisiblePosition = this.f75956d.getLastVisiblePosition();
        if (c16 >= firstVisiblePosition && c16 <= lastVisiblePosition) {
            int i3 = (c16 + 1) - firstVisiblePosition;
            if (i3 > this.f75956d.getChildCount()) {
                return;
            }
            View childAt = this.f75956d.getChildAt(i3);
            if (childAt == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view == null , index = " + c16);
                    return;
                }
                return;
            }
            if (childAt.getTag() == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + c16 + ",uin=" + j3 + ",isSpeak=" + z16);
                    return;
                }
                return;
            }
            e eVar = (e) childAt.getTag();
            if (eVar == null) {
                return;
            }
            if (z16 && eVar.f75987j) {
                eVar.f75983f.setVisibility(0);
                View view = eVar.f75984g;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            eVar.f75983f.setVisibility(8);
            View view2 = eVar.f75984g;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view is invisible uin =" + j3 + " , index = " + c16);
        }
    }

    public void e(ArrayList<com.tencent.av.e> arrayList) {
        if (arrayList != null) {
            h(arrayList);
            this.f75957e.notifyDataSetChanged();
        }
    }

    public void f() {
        int childCount = this.f75956d.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            this.f75956d.getChildAt(i3).setTag(null);
        }
        this.f75956d = null;
        this.f75957e = null;
        this.f75958f = null;
        this.f75959g = null;
        ArrayList<c> arrayList = this.f75960h;
        if (arrayList != null) {
            arrayList.clear();
        }
        WeakReference<Context> weakReference = this.f75953a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f75953a = null;
    }

    public void g(long j3, boolean z16) {
        int c16 = c(j3);
        if (c16 == -1) {
            if (QLog.isColorLevel()) {
                QLog.e("GAudioMemberListCtrl", 2, "onSetMicBySelf uin=" + j3 + ",isMicOffBySelf=" + z16);
                return;
            }
            return;
        }
        this.f75960h.get(c16).f75975j = z16;
    }

    public void i() {
        int firstVisiblePosition = this.f75956d.getFirstVisiblePosition();
        boolean z16 = false;
        if (firstVisiblePosition < 0) {
            firstVisiblePosition = 0;
        }
        int lastVisiblePosition = this.f75956d.getLastVisiblePosition();
        int i3 = firstVisiblePosition;
        while (true) {
            if (i3 >= lastVisiblePosition || i3 >= this.f75960h.size()) {
                break;
            }
            c cVar = this.f75960h.get(i3);
            if (cVar != null && !cVar.f75968c) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GAudioMemberListCtrl", 2, "refreshHeadbitmap-->minIndex=" + firstVisiblePosition + ",maxIndex=" + lastVisiblePosition + ",needRefresh=" + z16);
        }
        if (z16) {
            this.f75957e.notifyDataSetChanged();
        }
    }

    public void j(long j3, int i3, int i16, boolean z16) {
        int i17;
        int c16 = c(j3);
        if (c16 == -1) {
            if (QLog.isColorLevel()) {
                QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + j3 + ",isMicOff=" + z16);
                return;
            }
            return;
        }
        c cVar = this.f75960h.get(c16);
        cVar.f75974i = z16;
        cVar.f75972g = i3;
        int firstVisiblePosition = this.f75956d.getFirstVisiblePosition();
        int lastVisiblePosition = this.f75956d.getLastVisiblePosition();
        if (c16 < firstVisiblePosition || c16 > lastVisiblePosition || (i17 = (c16 + 1) - firstVisiblePosition) > this.f75956d.getChildCount()) {
            return;
        }
        View childAt = this.f75956d.getChildAt(i17);
        if (childAt == null) {
            if (QLog.isColorLevel()) {
                QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view == null , index = " + c16);
                return;
            }
            return;
        }
        if (childAt.getTag() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + c16 + ",uin=" + j3 + ",isMicOff=" + z16);
                return;
            }
            return;
        }
        e eVar = (e) childAt.getTag();
        if (eVar == null) {
            return;
        }
        if (cVar.f75974i) {
            eVar.f75983f.setVisibility(8);
            View view = eVar.f75984g;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        boolean z17 = cVar.f75974i;
        if (z17) {
            int i18 = eVar.f75988k;
            if (i18 == -1 || i18 == 0) {
                k(eVar.f75982e, z17);
                eVar.f75988k = 1;
                return;
            }
            return;
        }
        int i19 = eVar.f75988k;
        if (i19 == -1 || i19 == 1) {
            k(eVar.f75982e, z17);
            eVar.f75988k = 0;
        }
    }

    void k(ImageView imageView, boolean z16) {
        if (z16) {
            imageView.setImageResource(R.drawable.he8);
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.mzn));
        } else {
            imageView.setImageResource(R.drawable.he9);
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.mzp));
        }
    }
}
