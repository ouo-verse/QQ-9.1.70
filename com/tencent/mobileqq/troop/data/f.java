package com.tencent.mobileqq.troop.data;

import NearbyGroup.Color;
import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f294899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements TextUtils.EllipsizeCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f294900a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f294901b;

        a(b bVar, String str) {
            this.f294900a = bVar;
            this.f294901b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) str);
            }
        }

        @Override // android.text.TextUtils.EllipsizeCallback
        public void ellipsized(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == i16) {
                this.f294900a.E.setText(this.f294901b);
                return;
            }
            String substring = this.f294901b.substring(0, i3);
            this.f294900a.E.setText(new QQText(HttpUtil.unEscape(HttpUtil.removeHtmlTags(substring + MiniBoxNoticeInfo.APPNAME_SUFFIX)), 3, 14));
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b extends com.tencent.mobileqq.adapter.k {
        static IPatchRedirector $redirector_;
        public TroopLabelLayout C;
        public TroopLabelLayout D;
        public TextView E;
        public ImageView F;
        public ImageView G;
        public int H;
        public int I;
        public String J;
        public boolean K;
        public ArrayList<GroupLabel> L;
        public LinearLayout M;
        public LinearLayout N;
        public TextView P;
        public int Q;
        public View R;
        public GroupInfo S;
        public TextView T;
        public RelativeLayout U;
        public Button V;

        /* renamed from: i, reason: collision with root package name */
        public TextView f294902i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f294903m;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.I = 2;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76240);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f294899a = AppSetting.f99565y;
        }
    }

    public static View a(Context context, ViewGroup viewGroup, int i3, int i16) {
        View inflate = LayoutInflater.from(context).inflate(i16, viewGroup, false);
        b bVar = new b();
        bVar.f187212f = (ImageView) inflate.findViewById(R.id.jyu);
        bVar.f294902i = (TextView) inflate.findViewById(R.id.k0i);
        bVar.f294903m = (TextView) inflate.findViewById(R.id.jxq);
        TroopLabelLayout troopLabelLayout = (TroopLabelLayout) inflate.findViewById(R.id.jzj);
        bVar.C = troopLabelLayout;
        troopLabelLayout.setLabelType(i3);
        TroopLabelLayout troopLabelLayout2 = (TroopLabelLayout) inflate.findViewById(R.id.jzk);
        bVar.D = troopLabelLayout2;
        troopLabelLayout2.setLabelType(2);
        TextView textView = (TextView) inflate.findViewById(R.id.bmn);
        bVar.T = textView;
        bVar.C.setDistanceTextView(textView);
        bVar.E = (TextView) inflate.findViewById(R.id.jyh);
        bVar.F = (ImageView) inflate.findViewById(R.id.jxg);
        bVar.G = (ImageView) inflate.findViewById(R.id.jwi);
        bVar.U = (RelativeLayout) inflate.findViewById(R.id.ide);
        bVar.V = (Button) inflate.findViewById(R.id.dzc);
        bVar.f187212f.setImageBitmap(null);
        bVar.M = (LinearLayout) inflate.findViewById(R.id.dq8);
        bVar.N = (LinearLayout) inflate.findViewById(R.id.j8u);
        bVar.P = (TextView) inflate.findViewById(R.id.jxo);
        bVar.R = inflate.findViewById(R.id.e_1);
        bVar.Q = i3;
        inflate.setTag(bVar);
        return inflate;
    }

    public static void b(View view, GroupInfo groupInfo, Context context, boolean z16) {
        c(view, groupInfo, context, z16, false);
    }

    public static void c(View view, GroupInfo groupInfo, Context context, boolean z16, boolean z17) {
        d(view, groupInfo, context, z16, true, z17);
    }

    public static void d(View view, GroupInfo groupInfo, Context context, boolean z16, boolean z17, boolean z18) {
        int f16;
        ArrayList<GroupLabel> arrayList;
        b bVar = (b) view.getTag();
        bVar.f187210d = String.valueOf(groupInfo.lCode);
        bVar.f294902i.setText(groupInfo.strName);
        bVar.f294902i.setTextColor(context.getResources().getColor(R.color.skin_black_theme_version2));
        if (z17 && (arrayList = groupInfo.labels) != null) {
            Iterator<GroupLabel> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GroupLabel next = it.next();
                if (next.type == 2001) {
                    Color color = next.text_color;
                    bVar.f294902i.setTextColor(android.graphics.Color.rgb((int) color.R, (int) color.G, (int) color.B));
                    break;
                }
            }
        }
        if (z16 || z18) {
            bVar.U.setVisibility(0);
        }
        if (z18) {
            bVar.V.setVisibility(0);
        }
        bVar.E.setVisibility(0);
        if (TextUtils.isEmpty(groupInfo.strIntro)) {
            bVar.E.setText(R.string.drk);
        } else {
            int i3 = context.getResources().getDisplayMetrics().widthPixels;
            if (bVar.I == 1) {
                f16 = i3 - BaseAIOUtils.f(110.0f, context.getResources());
            } else {
                f16 = (i3 - BaseAIOUtils.f(137.0f, context.getResources())) * 2;
            }
            String unEscape = HttpUtil.unEscape(HttpUtil.removeHtmlTags(groupInfo.strIntro));
            TextUtils.ellipsize(unEscape, bVar.E.getPaint(), f16, TextUtils.TruncateAt.END, false, new a(bVar, unEscape));
        }
        bVar.S = groupInfo;
        ArrayList<GroupLabel> arrayList2 = groupInfo.labels;
        if (arrayList2 != null && arrayList2.size() != 0) {
            if (!e(context, bVar, groupInfo) && QLog.isColorLevel()) {
                QLog.e("NearbyTroops", 2, "fillTroopLabels failed:" + groupInfo.strName);
            }
        } else {
            ArrayList<GroupLabel> arrayList3 = bVar.L;
            if (arrayList3 == null || arrayList3.size() == 0) {
                ArrayList<GroupLabel> arrayList4 = new ArrayList<>(1);
                arrayList4.add(new GroupLabel(groupInfo.iMemberCnt + "", new Color(175L, 195L, 213L), 1L, new Color(190L, 206L, 220L)));
                bVar.L = arrayList4;
            }
            bVar.L.get(0).strWording = groupInfo.iMemberCnt + "";
            groupInfo.labels = bVar.L;
            e(context, bVar, groupInfo);
        }
        if ((groupInfo.dwGroupFlagExt & 2048) != 0) {
            long j3 = groupInfo.dwCertType;
            if (j3 == 2) {
                bVar.F.setVisibility(0);
                bVar.F.setBackgroundResource(R.drawable.e5d);
            } else if (j3 == 1) {
                bVar.F.setVisibility(0);
                bVar.F.setBackgroundResource(R.drawable.e5d);
            } else {
                bVar.F.setVisibility(8);
            }
        } else {
            bVar.F.setVisibility(8);
        }
        if ((1 & groupInfo.dwExtFlag) != 0) {
            bVar.G.setBackgroundResource(R.drawable.brv);
            bVar.G.setVisibility(0);
        } else {
            bVar.G.setVisibility(8);
        }
        if (f294899a) {
            String str = "" + groupInfo.strName;
            String str2 = groupInfo.iMemberCnt + HardCodeUtil.qqStr(R.string.oly);
            if (groupInfo.labels != null) {
                StringBuffer stringBuffer = new StringBuffer();
                int size = groupInfo.labels.size();
                for (int i16 = 0; i16 < size; i16++) {
                    GroupLabel groupLabel = groupInfo.labels.get(i16);
                    if (groupLabel != null && !TextUtils.isEmpty(groupLabel.strWording)) {
                        stringBuffer.append(groupLabel.strWording);
                        stringBuffer.append(" ");
                    }
                }
                if (stringBuffer.length() > 0) {
                    str2 = stringBuffer.toString();
                }
            }
            bVar.f294903m.setContentDescription(str2);
            view.setContentDescription((str + str2) + groupInfo.strIntro);
        }
    }

    protected static boolean e(Context context, b bVar, GroupInfo groupInfo) {
        ArrayList<GroupLabel> arrayList;
        if (context == null || bVar == null || groupInfo == null || (arrayList = groupInfo.labels) == null || arrayList.size() == 0) {
            return false;
        }
        bVar.f294903m.setVisibility(8);
        bVar.C.setVisibility(0);
        ArrayList<GroupLabel> arrayList2 = groupInfo.labels;
        bVar.D.f(arrayList2);
        return bVar.C.f(arrayList2);
    }

    public static void f(Context context, AppInterface appInterface) {
    }
}
