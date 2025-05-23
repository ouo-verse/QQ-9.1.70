package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.fragment.app.FragmentActivity;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.member.ExclusiveHbSelectMemberHandler;
import com.tencent.mobileqq.qwallet.hb.send.impl.ExclusiveHbFragment;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.selectmember.event.TroopSelectMemberSingleModeItemClickEvent;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExclusiveHbFragment extends BaseHbFragment implements View.OnClickListener, SimpleEventReceiver {
    private Button K;
    private TextView L;
    private TextView M;
    private EditText N;
    private EditText P;
    private View Q;
    private View R;
    private TextView S;
    private TextView T;
    private LinearLayout U;
    private String X;
    private String Y;

    /* renamed from: a0, reason: collision with root package name */
    private int f277651a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f277652b0;

    /* renamed from: e0, reason: collision with root package name */
    private long f277655e0;
    private final HbInfo.a V = new HbInfo.a();
    private final ArrayList<String> W = new ArrayList<>();
    private String Z = "";

    /* renamed from: c0, reason: collision with root package name */
    protected TextWatcher f277653c0 = new a();

    /* renamed from: d0, reason: collision with root package name */
    protected TextWatcher f277654d0 = new b();

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends x05.b {
        a() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ExclusiveHbFragment.this.Lh();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends x05.b {
        b() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z16;
            String obj = ExclusiveHbFragment.this.N.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            if (ExclusiveHbFragment.this.f277651a0 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int size = ExclusiveHbFragment.this.W.size();
            float i3 = x05.c.i(obj);
            if (z16 && !zk2.b.f452710a.k(i3)) {
                ExclusiveHbFragment.this.Yh(true);
                return;
            }
            if (!z16 && size != 0 && !zk2.b.f452710a.k(i3 / size)) {
                ExclusiveHbFragment.this.Yh(true);
            } else if (!zk2.b.f452710a.i(i3)) {
                ExclusiveHbFragment.this.Yh(true);
            } else {
                ExclusiveHbFragment.this.Yh(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c extends x05.b {
        c() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!ExclusiveHbFragment.this.P.getText().toString().isEmpty() && ExclusiveHbFragment.this.P.isFocused()) {
                ExclusiveHbFragment.this.Q.setVisibility(0);
                ExclusiveHbFragment.this.R.setVisibility(8);
            } else {
                ExclusiveHbFragment.this.Q.setVisibility(8);
                ExclusiveHbFragment.this.R.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface d {
        void a(ArrayList<ArrayList<String>> arrayList);
    }

    private void Hh() {
        this.S.setClickable(false);
        Lh();
    }

    private void Ih() {
        float i3 = x05.c.i(this.N.getText().toString());
        int i16 = this.f277652b0;
        if (i16 == 0) {
            return;
        }
        zk2.b bVar = zk2.b.f452710a;
        boolean m3 = bVar.m(i16);
        if (i3 != 0.0f && m3) {
            int i17 = this.f277651a0;
            if (i17 == 2) {
                bVar.j(i3 / this.f277652b0);
            } else if (i17 == 1) {
                bVar.i(i3);
            }
        }
    }

    private void Jh() {
        this.W.clear();
        this.U.removeAllViews();
        this.U.setContentDescription(HardCodeUtil.qqStr(R.string.f21743610));
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.f21743610);
        textView.setSingleLine();
        textView.setTextSize(15.0f);
        textView.setTextColor(getActivity().getResources().getColor(R.color.qui_common_text_secondary));
        com.tencent.mobileqq.qwallet.impl.d.y(this.U, 0.6f);
        this.U.addView(textView);
        Lh();
    }

    private void Kh(final ArrayList<ArrayList<String>> arrayList, final ArrayList<String> arrayList2, final ArrayList<String> arrayList3, final List<String> list, final List<ResultRecord> list2, final d dVar) {
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fetchTroopMemberInfoByUins(this.Y, list, false, getViewLifecycleOwner(), "ExclusiveHbFragment", new com.tencent.mobileqq.troop.d() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.g
            @Override // com.tencent.mobileqq.troop.d
            public final void a(Boolean bool, List list3) {
                ExclusiveHbFragment.this.Qh(list, list2, arrayList2, arrayList3, arrayList, dVar, bool, list3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh() {
        float Mh = Mh();
        this.T.setText(new DecimalFormat(getQBaseActivity().getResources().getString(R.string.f17939399)).format(Mh));
        if (Mh <= 0.0f) {
            this.K.setEnabled(false);
        } else if (!this.W.isEmpty() && !TextUtils.isEmpty(this.N.getText().toString())) {
            this.Z = String.valueOf(Mh);
            this.K.setEnabled(true);
        } else {
            this.K.setEnabled(false);
        }
    }

    private void Nh() {
        EditText editText = this.P;
        if (editText != null && this.Q != null && this.R != null) {
            editText.addTextChangedListener(new c());
            this.P.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.h
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z16) {
                    ExclusiveHbFragment.this.Rh(view, z16);
                }
            });
            this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExclusiveHbFragment.this.Sh(view);
                }
            });
        }
    }

    private void Oh(View view, Bundle bundle) {
        HbInfo.c(bundle, this.V);
        this.X = this.V.recv_type;
        this.Y = bundle.getString("recv_uin");
        this.M = (TextView) view.findViewById(R.id.f167050md3);
        this.L = (TextView) view.findViewById(R.id.mcz);
        EditText editText = (EditText) view.findViewById(R.id.f164306ro);
        this.N = editText;
        editText.addTextChangedListener(this.f277653c0);
        EditText editText2 = this.N;
        editText2.addTextChangedListener(new bl2.e(editText2));
        this.N.addTextChangedListener(this.f277654d0);
        this.K = (Button) view.findViewById(R.id.b7m);
        this.P = (EditText) view.findViewById(R.id.lgj);
        this.S = (TextView) view.findViewById(R.id.mcz);
        this.T = (TextView) view.findViewById(R.id.f165664x71);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lq_);
        this.U = linearLayout;
        linearLayout.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.P.setHint(bl2.b.b(this.G, this.V, HardCodeUtil.qqStr(R.string.mao)));
        this.Q = view.findViewById(R.id.z2n);
        this.R = view.findViewById(R.id.z2o);
        Nh();
        Typeface createFromAsset = Typeface.createFromAsset(getQBaseActivity().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        this.T.setTypeface(createFromAsset);
        ((TextView) view.findViewById(R.id.f165663x70)).setTypeface(createFromAsset);
        if (QLog.isColorLevel()) {
            QLog.i("ExclusiveHbFragment", 2, "bizParams:" + this.V.biz_params);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(List list, List list2, ArrayList arrayList, ArrayList arrayList2, final ArrayList arrayList3, final d dVar, Boolean bool, List list3) {
        HashMap hashMap = new HashMap();
        for (Object obj : list3) {
            if (obj instanceof TroopMemberInfo) {
                TroopMemberInfo troopMemberInfo = (TroopMemberInfo) obj;
                hashMap.put(troopMemberInfo.memberuin, troopMemberInfo);
            }
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            TroopMemberInfo troopMemberInfo2 = (TroopMemberInfo) hashMap.get(list.get(i3));
            ResultRecord resultRecord = (ResultRecord) list2.get(i3);
            arrayList.add(resultRecord.uin);
            if (troopMemberInfo2 != null) {
                if (!TextUtils.isEmpty(troopMemberInfo2.autoremark)) {
                    resultRecord.name = troopMemberInfo2.autoremark;
                } else if (!TextUtils.isEmpty(troopMemberInfo2.troopnick)) {
                    resultRecord.name = troopMemberInfo2.troopnick;
                } else if (!TextUtils.isEmpty(troopMemberInfo2.friendnick)) {
                    resultRecord.name = troopMemberInfo2.friendnick;
                } else {
                    resultRecord.name = troopMemberInfo2.memberuin;
                }
            }
            if (!TextUtils.isEmpty(resultRecord.name)) {
                arrayList2.add(resultRecord.name);
            }
        }
        arrayList3.add(arrayList);
        arrayList3.add(arrayList2);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                ExclusiveHbFragment.d.this.a(arrayList3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rh(View view, boolean z16) {
        if (!this.P.getText().toString().isEmpty() && this.P.isFocused()) {
            this.Q.setVisibility(0);
            this.R.setVisibility(8);
        } else {
            this.Q.setVisibility(8);
            this.R.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.P.setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Th(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 1) {
            Uh((List) arrayList.get(0), (List) arrayList.get(1));
        } else {
            Jh();
        }
    }

    private void Vh(int i3, Intent intent) {
        List<String> asList;
        if (i3 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra(IQQGuildRouterApi.SELECT_MEMBER_LIST);
            String[] stringArrayExtra2 = intent.getStringArrayExtra(IQQGuildRouterApi.SELECT_MEMBER_NAME_LIST);
            if (stringArrayExtra != null && stringArrayExtra.length != 0) {
                List<String> asList2 = Arrays.asList(stringArrayExtra);
                if (stringArrayExtra2 == null) {
                    asList = null;
                } else {
                    asList = Arrays.asList(stringArrayExtra2);
                }
                Uh(asList2, asList);
                return;
            }
            return;
        }
        QLog.e("ExclusiveHbFragment", 4, "onSendGiftMemberSelect: resultCode=" + i3 + ", data=" + intent);
    }

    private void Wh(Intent intent, d dVar) {
        String discussMemberName;
        if (this.D == null) {
            dVar.a(null);
            return;
        }
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        try {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) this.D.getAppRuntime();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (intent == null) {
                dVar.a(arrayList);
                return;
            }
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            if (parcelableArrayListExtra != null) {
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    ResultRecord resultRecord = (ResultRecord) it.next();
                    if (!TextUtils.isEmpty(resultRecord.uin)) {
                        if (this.X.equals("3") && TextUtils.isEmpty(resultRecord.name)) {
                            arrayList4.add(resultRecord.uin);
                            arrayList5.add(resultRecord);
                        } else {
                            arrayList2.add(resultRecord.uin);
                            if (TextUtils.isEmpty(resultRecord.name)) {
                                if (this.X.equals("1")) {
                                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(resultRecord.uin);
                                    com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                                    aVar.d(uidFromUin);
                                    resultRecord.name = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                                } else if (this.X.equals("2") && (discussMemberName = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getDiscussMemberName(baseQQAppInterface, this.Y, resultRecord.uin)) != null) {
                                    resultRecord.name = discussMemberName;
                                }
                            }
                            if (!TextUtils.isEmpty(resultRecord.name)) {
                                arrayList3.add(resultRecord.name);
                            }
                        }
                    }
                }
            }
            if (arrayList4.isEmpty()) {
                arrayList.add(arrayList2);
                arrayList.add(arrayList3);
                dVar.a(arrayList);
                return;
            }
            Kh(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, dVar);
        } catch (Throwable th5) {
            QLog.e("ExclusiveHbFragment", 1, th5, new Object[0]);
        }
    }

    private String Zh(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                stringBuffer.append(arrayList.get(i3));
                if (i3 != size - 1) {
                    stringBuffer.append("|");
                }
            } catch (Exception e16) {
                QLog.e("ExclusiveHbFragment", 1, "error msg in qqpay-impl module: ", e16);
            }
        }
        return stringBuffer.toString();
    }

    private void initData() {
        this.f277651a0 = 2;
        Hh();
        Jh();
    }

    private void onConfirmClick() {
        String str;
        float Mh = Mh();
        if (Mh <= 0.0f) {
            Yh(true);
            zk2.b.o("\u8bf7\u586b\u5199\u7ea2\u5305\u91d1\u989d");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f277655e0 + 1000 > currentTimeMillis) {
            return;
        }
        this.f277655e0 = currentTimeMillis;
        int size = this.W.size();
        Map<String, String> mapPacketExtra = this.D.getMapPacketExtra();
        try {
            String Zh = Zh(this.W);
            if (size != 0 && !TextUtils.isEmpty(Zh)) {
                mapPacketExtra.put("grab_uin_list", Zh);
                if (this.f277651a0 == 2 && !zk2.b.f452710a.j(Mh / size)) {
                    return;
                }
                qh(this.V, this.G, this.f277652b0, x05.c.l(this.Z), "only.wrappacket.wrap");
                mapPacketExtra.put("type", String.valueOf(1));
                mapPacketExtra.put("wishing", bl2.b.c(this.P));
                mapPacketExtra.put("bus_type", this.f277651a0 + "");
                mapPacketExtra.put("total_num", this.f277652b0 + "");
                mapPacketExtra.put("total_amount", x05.c.l(this.Z));
                mapPacketExtra.put(WadlProxyConsts.CHANNEL, String.valueOf(this.G));
                this.F.b(mapPacketExtra);
                if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.V.recv_type)) {
                    str = this.V.guild_id;
                } else {
                    str = this.V.recv_uin;
                }
                HbInfo.a aVar = this.V;
                ReportUtils.g("redpack.paybtn.click", aVar.recv_type, aVar.panel_name, "", str);
                return;
            }
            zk2.b bVar = zk2.b.f452710a;
            zk2.b.o(HardCodeUtil.qqStr(R.string.man));
        } catch (Exception e16) {
            QLog.e("ExclusiveHbFragment", 1, e16, new Object[0]);
        }
    }

    protected float Mh() {
        this.f277652b0 = this.W.size();
        float i3 = x05.c.i(this.N.getText().toString());
        if (this.f277651a0 == 1) {
            return this.f277652b0 * i3;
        }
        return i3;
    }

    public void Uh(List<String> list, List<String> list2) {
        int i3;
        Drawable faceDrawable;
        if (!isDetached() && this.U != null) {
            if (list != null && list.size() > 0) {
                this.W.clear();
                this.W.addAll(list);
                this.U.removeAllViews();
                int size = list.size();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i16 = 0; i16 < size; i16++) {
                    try {
                        String str = list.get(i16);
                        ImageView imageView = new ImageView(getActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(24.0f), ViewUtils.dpToPx(24.0f));
                        if (i16 == 0) {
                            i3 = ViewUtils.dip2px(70.0f);
                        } else {
                            i3 = -ViewUtils.dip2px(5.0f);
                        }
                        layoutParams.setMargins(i3, 0, 0, 0);
                        imageView.setLayoutParams(layoutParams);
                        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.V.recv_type)) {
                            faceDrawable = ((IQQGuildAvatarApi) this.E.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(this.E, this.V.guild_id, str);
                        } else {
                            faceDrawable = FaceDrawable.getFaceDrawable((BaseQQAppInterface) getQBaseActivity().getAppRuntime(), 1, str);
                        }
                        imageView.setImageDrawable(faceDrawable);
                        this.U.addView(imageView);
                    } catch (Exception e16) {
                        QLog.e("ExclusiveHbFragment", 1, "error msg in qqpay-impl module: ", e16);
                    }
                }
                if (list2 != null) {
                    int size2 = list2.size();
                    TextView textView = new TextView(getQBaseActivity());
                    textView.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
                    textView.setTextSize(2, 16.0f);
                    textView.setPadding(ViewUtils.dip2px(8.0f), 0, 0, 0);
                    textView.setMaxLines(1);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    if (size2 == 1) {
                        textView.setText(list2.get(0));
                    } else {
                        textView.setText(size2 + "\u4eba");
                    }
                    this.U.addView(textView);
                    if (size2 > 0) {
                        for (int i17 = 0; i17 < size2; i17++) {
                            String str2 = list2.get(i17);
                            if (!TextUtils.isEmpty(str2)) {
                                stringBuffer.append(str2);
                            }
                            stringBuffer.append(" ,");
                        }
                    }
                }
                if (!TextUtils.isEmpty(stringBuffer)) {
                    this.U.setContentDescription(HardCodeUtil.qqStr(R.string.mar) + size + HardCodeUtil.qqStr(R.string.maq) + stringBuffer.toString());
                }
                Ih();
                Lh();
                return;
            }
            Jh();
        }
    }

    protected void Xh(@ColorInt int i3) {
        this.N.setTextColor(i3);
        this.M.setTextColor(i3);
        this.L.setTextColor(i3);
    }

    protected void Yh(boolean z16) {
        if (z16) {
            Xh(Color.parseColor("#FF5765"));
        } else {
            Xh(getResources().getColor(R.color.qui_common_text_primary));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(TroopSelectMemberSingleModeItemClickEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1024 && intent != null) {
            if (i16 == -1) {
                Wh(intent, new d() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.f
                    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.ExclusiveHbFragment.d
                    public final void a(ArrayList arrayList) {
                        ExclusiveHbFragment.this.Th(arrayList);
                    }
                });
            }
        } else if (i3 == 30001) {
            Vh(i16, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.b7m) {
            this.D.addHbUploadData("only.wrappacket.wrap");
            onConfirmClick();
        } else if (id5 == R.id.mcz) {
            if (this.f277651a0 == 1) {
                this.f277651a0 = 2;
            } else {
                this.f277651a0 = 1;
            }
            Hh();
        } else if (id5 == R.id.lq_) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f277655e0 + 1200 <= currentTimeMillis) {
                this.f277655e0 = currentTimeMillis;
                if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.V.recv_type)) {
                    IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                    SendHbActivity sendHbActivity = this.D;
                    iQQGuildRouterApi.openSingleMemberExcludeSelfSelector(sendHbActivity, this.E, sendHbActivity.getMapPacketExtra().get("guild_id"), this.Y, 30001);
                } else if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_EXCLUSIVE_HB_NEW_SELECTOR, true)) {
                    if (TextUtils.isEmpty(this.Y)) {
                        QLog.e("ExclusiveHbFragment", 1, "[onClick] troopUin is null");
                    } else {
                        ExclusiveHbSelectMemberHandler.d(this.Y, this.W);
                    }
                } else {
                    this.D.callForwardPage(this.V.recv_type, this.W, 1);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.ccd, (ViewGroup) null);
        Oh(inflate, getArguments());
        initData();
        SimpleEventBus.getInstance().registerReceiver(this);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        List<String> a16;
        List<String> a17;
        if (simpleBaseEvent instanceof TroopSelectMemberSingleModeItemClickEvent) {
            com.tencent.mobileqq.troop.selectmember.bean.c component2 = ((TroopSelectMemberSingleModeItemClickEvent) simpleBaseEvent).component2();
            if (component2.getItemData() instanceof TroopMemberInfo) {
                TroopMemberInfo troopMemberInfo = (TroopMemberInfo) component2.getItemData();
                a16 = com.tencent.mobileqq.guild.feed.widget.d.a(new Object[]{troopMemberInfo.memberuin});
                a17 = com.tencent.mobileqq.guild.feed.widget.d.a(new Object[]{troopMemberInfo.nickInfo.getShowName()});
                Uh(a16, a17);
                return;
            }
            QLog.e("ExclusiveHbFragment", 1, "[onReceiveEvent] data is not memberInfo");
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (z16) {
            QLog.i("ExclusiveHbFragment", 2, "ExclusiveHb enter...");
            SendHbActivity sendHbActivity = this.D;
            if (sendHbActivity != null) {
                sendHbActivity.addHbUploadData("only.wrappacket.show");
            }
        }
    }
}
