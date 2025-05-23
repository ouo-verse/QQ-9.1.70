package com.tencent.mobileqq.structmsg.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeperConstant;
import com.tencent.util.VersionUtils;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    public Bundle X0;
    public GradientDrawable Y0;
    public boolean Z0;

    /* renamed from: a1, reason: collision with root package name */
    private String f290644a1;

    /* renamed from: b1, reason: collision with root package name */
    View.OnClickListener f290645b1;

    /* renamed from: c1, reason: collision with root package name */
    public boolean f290646c1;

    /* renamed from: d1, reason: collision with root package name */
    public boolean f290647d1;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f290649d;

        b(View view) {
            this.f290649d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this, (Object) view);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        
            if (r8 != 3) goto L18;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    h.this.f290645b1.onClick(this.f290649d);
                }
                h.this.f290646c1 = false;
                ObjectAnimator objectAnimator = (ObjectAnimator) view.getTag(R.id.grw);
                if (objectAnimator != null) {
                    objectAnimator.reverse();
                }
                return false;
            }
            h hVar = h.this;
            if (!hVar.f290646c1) {
                hVar.f290646c1 = true;
                ObjectAnimator objectAnimator2 = (ObjectAnimator) view.getTag(R.id.grw);
                if (objectAnimator2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("StructMsgItemLayout12", 2, "animator is null");
                    }
                    objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(this.f290649d, PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, 0.9f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, 0.95f));
                    objectAnimator2.setInterpolator(new DecelerateInterpolator(2.0f));
                    objectAnimator2.setDuration(100L);
                    view.setTag(R.id.grw, objectAnimator2);
                }
                objectAnimator2.start();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f290651a;

        /* renamed from: b, reason: collision with root package name */
        public Bundle f290652b;

        /* renamed from: c, reason: collision with root package name */
        public View f290653c;

        /* renamed from: d, reason: collision with root package name */
        public View f290654d;

        /* renamed from: e, reason: collision with root package name */
        public View f290655e;

        /* renamed from: f, reason: collision with root package name */
        public View f290656f;

        /* renamed from: g, reason: collision with root package name */
        public View f290657g;

        /* renamed from: h, reason: collision with root package name */
        public LinearLayout f290658h;

        /* renamed from: i, reason: collision with root package name */
        public LinearLayout f290659i;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.X0 = new Bundle();
        this.Y0 = null;
        this.Z0 = false;
        this.f290645b1 = new a();
        this.f290646c1 = false;
        this.f290647d1 = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String E(String str) {
        byte[] bArr;
        if (!TextUtils.isEmpty(str)) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("StructMsgItemLayout12", 2, e16.getMessage());
                }
                bArr = null;
                return bArr != null ? str : str;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.i("StructMsgItemLayout12", 2, e17.getMessage());
                }
                bArr = null;
                if (bArr != null) {
                }
            }
            if (bArr != null && bArr.length > 0) {
                return new String(bArr);
            }
        }
        return str;
    }

    private FrameLayout F(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, BaseAIOUtils.f(105.0f, context.getResources())));
        frameLayout.setId(R.id.f6b);
        if (AppSetting.f99565y) {
            frameLayout.setContentDescription(this.f290644a1);
        }
        return frameLayout;
    }

    public static String G(AbsStructMsg absStructMsg) {
        StringBuilder sb5 = new StringBuilder();
        if (absStructMsg instanceof AbsShareMsg) {
            AbsShareMsg absShareMsg = (AbsShareMsg) absStructMsg;
            if (absShareMsg.getItemCount() > 0 && (absShareMsg.getItemByIndex(0) instanceof h)) {
                h hVar = (h) absShareMsg.getItemByIndex(0);
                boolean z16 = hVar.X0.getBoolean("isSend", false);
                sb5.append("isSend:");
                sb5.append(z16);
                sb5.append(" nick:");
                if (z16) {
                    sb5.append(hVar.X0.getString("rNick"));
                } else {
                    sb5.append(hVar.X0.getString("sNick"));
                }
            }
        }
        return sb5.toString();
    }

    @TargetApi(11)
    private void I(View view) {
        view.setOnTouchListener(new b(view));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0431  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H() {
        h hVar;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        int intValue;
        String str34;
        String str35;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.F);
            if (QLog.isColorLevel()) {
                try {
                    try {
                        i3 = 2;
                    } catch (Exception e16) {
                        e = e16;
                        hVar = this;
                        if (QLog.isColorLevel()) {
                            QLog.i("StructMsgItemLayout12", 2, e.getMessage());
                        }
                        hVar.Z0 = true;
                    }
                    try {
                        QLog.i("StructMsgItemLayout12", 2, jSONObject.toString());
                    } catch (JSONException e17) {
                        e = e17;
                        hVar = this;
                        if (QLog.isColorLevel()) {
                            QLog.i("StructMsgItemLayout12", i3, e.getMessage());
                        }
                        hVar.Z0 = true;
                    }
                } catch (JSONException e18) {
                    e = e18;
                    i3 = 2;
                }
            }
            try {
                String str36 = "";
                if (!jSONObject.has("fMean")) {
                    str = "";
                } else {
                    str = jSONObject.getString("fMean");
                }
                if (jSONObject.has("cMean")) {
                    str2 = "";
                    str36 = jSONObject.getString("cMean");
                } else {
                    str2 = "";
                }
                if (jSONObject.has("bgPic")) {
                    str3 = str36;
                    str4 = jSONObject.getString("bgPic");
                } else {
                    str3 = str36;
                    str4 = str2;
                }
                if (jSONObject.has("fPic")) {
                    str5 = "fMean";
                    str6 = "cMean";
                    str7 = jSONObject.getString("fPic");
                } else {
                    str5 = "fMean";
                    str6 = "cMean";
                    str7 = str2;
                }
                if (jSONObject.has(TVKPlaybackAliveKeeperConstant.POLLING_REPORT_REQUEST_KEY_SESSION_INFO)) {
                    str9 = jSONObject.getString(TVKPlaybackAliveKeeperConstant.POLLING_REPORT_REQUEST_KEY_SESSION_INFO);
                    str8 = str;
                } else {
                    str8 = str;
                    str9 = str2;
                }
                if (jSONObject.has("rinfo")) {
                    str10 = jSONObject.getString("rinfo");
                } else {
                    str10 = str2;
                }
                if (jSONObject.has(LocalPhotoFaceInfo.SCORE)) {
                    str11 = "fPic";
                    str12 = jSONObject.getString(LocalPhotoFaceInfo.SCORE);
                } else {
                    str11 = "fPic";
                    str12 = str2;
                }
                if (jSONObject.has("pID")) {
                    str13 = jSONObject.getString("pID");
                } else {
                    str13 = str2;
                }
                if (jSONObject.has("pURL")) {
                    str14 = jSONObject.getString("pURL");
                } else {
                    str14 = str2;
                }
                if (jSONObject.has("fCount")) {
                    str15 = jSONObject.getString("fCount");
                } else {
                    str15 = str2;
                }
                if (jSONObject.has("rUin")) {
                    str16 = "pURL";
                    str17 = jSONObject.getString("rUin");
                } else {
                    str16 = "pURL";
                    str17 = str2;
                }
                if (jSONObject.has("sUin")) {
                    str18 = "pID";
                    str19 = jSONObject.getString("sUin");
                } else {
                    str18 = "pID";
                    str19 = str2;
                }
                if (jSONObject.has("rSex")) {
                    str20 = "fCount";
                    str21 = jSONObject.getString("rSex");
                } else {
                    str20 = "fCount";
                    str21 = str2;
                }
                if (jSONObject.has("sSex")) {
                    str22 = str7;
                    str23 = jSONObject.getString("sSex");
                } else {
                    str22 = str7;
                    str23 = str2;
                }
                if (jSONObject.has("rNick")) {
                    str24 = str12;
                    str25 = jSONObject.getString("rNick");
                } else {
                    str24 = str12;
                    str25 = str2;
                }
                String str37 = str10;
                if (jSONObject.has("sNick")) {
                    str26 = str9;
                    str27 = jSONObject.getString("sNick");
                } else {
                    str26 = str9;
                    str27 = str2;
                }
                String str38 = str4;
                if (jSONObject.has("version")) {
                    str28 = jSONObject.getString("version");
                } else {
                    str28 = str2;
                }
                if (jSONObject.has("groupCode")) {
                    str29 = jSONObject.getString("groupCode");
                } else {
                    str29 = str2;
                }
                if (jSONObject.has("gScore")) {
                    str30 = jSONObject.getString("gScore");
                } else {
                    str30 = str2;
                }
                if (!jSONObject.has("sID")) {
                    str31 = "sID";
                    str32 = str2;
                } else {
                    str32 = jSONObject.getString("sID");
                    str31 = "sID";
                }
                if (jSONObject.has("aNony")) {
                    str33 = jSONObject.getString("aNony");
                } else {
                    str33 = str2;
                }
                if (TextUtils.isEmpty(str15)) {
                    intValue = 0;
                } else {
                    intValue = Integer.valueOf(str15).intValue();
                }
                String str39 = str33;
                String currentUin = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
                int i16 = intValue;
                boolean equals = str19.equals(currentUin);
                boolean equals2 = str17.equals(currentUin);
                hVar = this;
                try {
                    String str40 = str23;
                    hVar.X0.putBoolean("isSend", equals);
                    hVar.X0.putBoolean("isReceive", equals2);
                    Iterator<AbsStructMsgElement> it = hVar.U0.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            AbsStructMsgElement next = it.next();
                            Iterator<AbsStructMsgElement> it5 = it;
                            if (next instanceof com.tencent.mobileqq.structmsg.view.c) {
                                str34 = ((com.tencent.mobileqq.structmsg.view.c) next).S0;
                                break;
                            }
                            it = it5;
                        } else {
                            str34 = null;
                            break;
                        }
                    }
                    String E = hVar.E(str25);
                    String E2 = hVar.E(str27);
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                    String str41 = str34;
                    hVar.X0.putString("sNick", E2);
                    if (!equals && com.tencent.qqnt.contact.friends.b.f355778a.c(str19, "StructMsgItemLayout12")) {
                        hVar.X0.putString("sNick", com.tencent.mobileqq.utils.ac.y(qQAppInterface, str19));
                        if (equals2) {
                            hVar.X0.putBoolean(IProfileProtocolConst.PARAM_IS_FRIEND, true);
                        }
                    }
                    hVar.X0.putString("rNick", E);
                    if (!equals2 && com.tencent.qqnt.contact.friends.b.f355778a.c(str17, "StructMsgItemLayout12")) {
                        hVar.X0.putString("rNick", com.tencent.mobileqq.utils.ac.y(qQAppInterface, str17));
                        if (equals) {
                            hVar.X0.putBoolean(IProfileProtocolConst.PARAM_IS_FRIEND, true);
                        }
                    }
                    hVar.X0.putString("rUin", str17);
                    hVar.X0.putString("sUin", str19);
                    hVar.X0.putString("rSex", str21);
                    hVar.X0.putString("sSex", str40);
                    hVar.X0.putString("bgPic", str38);
                    hVar.X0.putString("sInfo", str26);
                    hVar.X0.putString("rInfo", str37);
                    hVar.X0.putString(LocalPhotoFaceInfo.SCORE, str24);
                    hVar.X0.putString(str11, str22);
                    hVar.X0.putString(str5, str8);
                    String str42 = str3;
                    hVar.X0.putString(str6, str42);
                    hVar.X0.putString(str20, str15);
                    hVar.X0.putInt("count", i16);
                    hVar.X0.putString(str18, str13);
                    hVar.X0.putString(str16, str14);
                    hVar.X0.putString("version", str28);
                    hVar.X0.putString("groupCode", str29);
                    hVar.X0.putString("gScore", str30);
                    if (!TextUtils.isEmpty(str41)) {
                        hVar.X0.putString("cover", str41);
                    }
                    hVar.X0.putString(str31, str32);
                    if (!TextUtils.isEmpty(str39)) {
                        hVar.X0.putString("anonyInfo", str39);
                    }
                    if (AppSetting.f99565y && hVar.f290644a1 == null) {
                        StringBuilder sb5 = new StringBuilder();
                        if (equals) {
                            E = "\u6211";
                        }
                        sb5.append(E);
                        if (equals) {
                            str35 = "\u9001\u51fa";
                        } else {
                            str35 = "\u9001\u4f60";
                        }
                        sb5.append(str35);
                        sb5.append(str42);
                        sb5.append(',');
                        Iterator<AbsStructMsgElement> it6 = hVar.U0.iterator();
                        String str43 = null;
                        String str44 = null;
                        while (it6.hasNext()) {
                            AbsStructMsgElement next2 = it6.next();
                            String str45 = next2.f290322e;
                            if ("remark".equals(str45)) {
                                str44 = ((ao) next2).t();
                            } else if ("summary".equals(str45)) {
                                str43 = ((ap) next2).t();
                            }
                        }
                        sb5.append(str43);
                        sb5.append(",");
                        if (equals) {
                            sb5.append("\u5bf9\u65b9");
                            sb5.append(str44);
                        } else {
                            sb5.append(str44);
                        }
                        sb5.append("\u6309\u94ae");
                        hVar.f290644a1 = sb5.toString();
                    }
                } catch (JSONException e19) {
                    e = e19;
                    i3 = 2;
                    if (QLog.isColorLevel()) {
                    }
                    hVar.Z0 = true;
                } catch (Exception e26) {
                    e = e26;
                    if (QLog.isColorLevel()) {
                    }
                    hVar.Z0 = true;
                }
            } catch (JSONException e27) {
                e = e27;
                hVar = this;
            }
        } catch (JSONException e28) {
            e = e28;
            hVar = this;
        } catch (Exception e29) {
            e = e29;
            hVar = this;
        }
        hVar.Z0 = true;
    }

    @Override // com.tencent.mobileqq.structmsg.a, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) jVar)).booleanValue();
        }
        boolean d16 = super.d(jVar);
        if (QLog.isColorLevel()) {
            QLog.i("StructMsgItemLayout12", 2, "fromXml inited:" + this.Z0 + " " + hashCode());
        }
        if (!this.Z0) {
            H();
        }
        return d16;
    }

    @Override // com.tencent.mobileqq.structmsg.a, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        if (QLog.isColorLevel()) {
            QLog.i("StructMsgItemLayout12", 2, "readExternal inited:" + this.Z0 + " " + hashCode());
        }
        if (!this.Z0) {
            H();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 12;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "Layout12";
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a3  */
    @Override // com.tencent.mobileqq.structmsg.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View y(Context context, View view, Bundle bundle) {
        String str;
        c cVar;
        FrameLayout F;
        int i3;
        Iterator<AbsStructMsgElement> it;
        Iterator<AbsStructMsgElement> it5;
        int i16;
        Context context2 = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, context, view, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.i("StructMsgItemLayout12", 2, "getView inited:" + this.Z0 + " " + hashCode());
        }
        if (!this.Z0) {
            H();
        }
        int i17 = 0;
        boolean z16 = this.X0.getBoolean("isSend", false);
        boolean z17 = this.X0.getBoolean("isReceive", false);
        String string = this.X0.getString("groupCode");
        String string2 = this.X0.getString("rNick");
        if (!TextUtils.isEmpty(string)) {
            if (z16) {
                str = "0X800638D";
            } else if (z17) {
                str = "0X800638E";
            } else {
                str = "0X800638F";
            }
        } else if (z16) {
            str = "0X80060B1";
        } else {
            str = "0X80060B2";
        }
        NearbyFlowerManager.a(((BaseActivity) context2).app, str);
        Resources resources = context.getResources();
        boolean z18 = true;
        if (view != null && (view instanceof FrameLayout)) {
            F = (FrameLayout) view;
            if (F.getChildCount() == 2 && (F.getTag() instanceof c)) {
                cVar = (c) F.getTag();
                View view2 = cVar.f290655e;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                View view3 = cVar.f290656f;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                View view4 = cVar.f290654d;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
                View view5 = cVar.f290657g;
                if (view5 != null) {
                    view5.setVisibility(8);
                }
                if (!z16) {
                    cVar.f290659i.setPadding(0, 0, BaseAIOUtils.f(15.0f, resources), 0);
                } else {
                    cVar.f290659i.setPadding(BaseAIOUtils.f(15.0f, resources), 0, 0, 0);
                }
                it = this.U0.iterator();
                while (it.hasNext()) {
                    AbsStructMsgElement next = it.next();
                    next.O0 = this.O0;
                    String str2 = next.f290322e;
                    if ("title".equals(str2)) {
                        if (next instanceof StructMsgItemTitle) {
                            StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next;
                            structMsgItemTitle.N(z(), i17);
                            structMsgItemTitle.D(z18);
                            structMsgItemTitle.M(z18);
                        }
                        View c16 = next.c(context2, cVar.f290655e, bundle);
                        TextView textView = (TextView) c16.findViewById(R.id.kbs);
                        View view6 = cVar.f290655e;
                        if (view6 == null) {
                            cVar.f290655e = c16;
                            cVar.f290659i.addView(c16, i17);
                        } else {
                            view6.setVisibility(i17);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("StructMsgItemLayout12", 2, "getview title:" + ((com.tencent.mobileqq.structmsg.b) next).t() + " realText:" + ((Object) textView.getText()));
                        }
                        it5 = it;
                    } else if ("summary".equals(str2)) {
                        boolean z19 = next instanceof ap;
                        if (z19) {
                            ((ap) next).F("black");
                        }
                        View c17 = next.c(context2, cVar.f290656f, bundle);
                        TextView textView2 = (TextView) c17;
                        if (!TextUtils.isEmpty(string)) {
                            it5 = it;
                            textView2.setMaxLines(1);
                            if (z19) {
                                ((ap) next).E(string2);
                            }
                        } else {
                            it5 = it;
                            textView2.setMaxLines(2);
                        }
                        View view7 = cVar.f290656f;
                        if (view7 == null) {
                            cVar.f290656f = c17;
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams.setMargins(0, BaseAIOUtils.f(4.0f, resources), 0, 0);
                            cVar.f290659i.addView(c17, layoutParams);
                        } else {
                            view7.setVisibility(0);
                        }
                        ap apVar = (ap) next;
                        if (this.X0.size() > 0 && TextUtils.isEmpty(string)) {
                            this.X0.putString("cMeanPostfix", apVar.t());
                        }
                    } else {
                        it5 = it;
                        if ("picture".equals(str2)) {
                            com.tencent.mobileqq.structmsg.view.c cVar2 = (com.tencent.mobileqq.structmsg.view.c) next;
                            if (!cVar2.S0.startsWith("http")) {
                                i16 = 0;
                                cVar2.S0 = String.format("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s", cVar2.S0);
                            } else {
                                i16 = 0;
                            }
                            View c18 = next.c(context2, cVar.f290654d, bundle);
                            if (this.X0.getInt("count", i16) > 9) {
                                ((ImageView) c18).setScaleType(ImageView.ScaleType.FIT_END);
                            } else {
                                ((ImageView) c18).setScaleType(ImageView.ScaleType.FIT_CENTER);
                            }
                            View view8 = cVar.f290654d;
                            if (view8 == null) {
                                cVar.f290654d = c18;
                                c18.setFocusable(true);
                                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(BaseAIOUtils.f(115.0f, resources), -1);
                                layoutParams2.weight = 1.0f;
                                cVar.f290658h.addView(c18, !z16 ? 1 : 0, layoutParams2);
                            } else {
                                view8.setVisibility(0);
                                if (z16 != cVar.f290651a) {
                                    if (z16) {
                                        cVar.f290659i.bringToFront();
                                    } else {
                                        cVar.f290654d.bringToFront();
                                    }
                                }
                            }
                            if (VersionUtils.isHoneycomb()) {
                                I(cVar.f290654d);
                            } else {
                                cVar.f290654d.setOnClickListener(this.f290645b1);
                            }
                        } else if ("remark".equals(str2)) {
                            if (next instanceof ao) {
                                ((ao) next).F("#FF9B9B9B");
                            }
                            View c19 = next.c(context2, cVar.f290657g, bundle);
                            View view9 = cVar.f290657g;
                            if (view9 == null) {
                                cVar.f290657g = c19;
                                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                                layoutParams3.topMargin = BaseAIOUtils.f(7.0f, resources);
                                cVar.f290659i.addView(c19, layoutParams3);
                            } else {
                                view9.setVisibility(0);
                            }
                            ao aoVar = (ao) next;
                            if (this.X0.size() > 0) {
                                this.X0.putString("remark", aoVar.t());
                                if (!TextUtils.isEmpty(string)) {
                                    this.X0.putString("cMeanPostfix", aoVar.t());
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("StructMsgItemLayout12", 2, "getview remark:" + ((com.tencent.mobileqq.structmsg.b) next).t());
                            }
                            context2 = context;
                            it = it5;
                            i17 = 0;
                            z18 = true;
                        }
                    }
                    context2 = context;
                    it = it5;
                    i17 = 0;
                    z18 = true;
                }
                cVar.f290652b = this.X0;
                cVar.f290651a = z16;
                return F;
            }
        }
        cVar = new c();
        F = F(context);
        F.setTag(cVar);
        cVar.f290653c = new View(context2);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
        F.addView(cVar.f290653c, layoutParams4);
        layoutParams4.setMargins(0, BaseAIOUtils.f(10.0f, resources), 0, 0);
        if (this.Y0 == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.Y0 = gradientDrawable;
            gradientDrawable.setShape(0);
            this.Y0.setColor(-1);
            this.Y0.setCornerRadius(BaseAIOUtils.f(14.0f, resources));
        }
        cVar.f290653c.setBackgroundDrawable(this.Y0);
        LinearLayout linearLayout = new LinearLayout(context2);
        cVar.f290658h = linearLayout;
        linearLayout.setOrientation(0);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -1);
        cVar.f290658h.setGravity(16);
        F.addView(cVar.f290658h, layoutParams5);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        cVar.f290659i = linearLayout2;
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(BaseAIOUtils.f(135.0f, resources), -2);
        layoutParams6.weight = 1.0f;
        layoutParams6.topMargin = BaseAIOUtils.f(5.0f, resources);
        LinearLayout linearLayout3 = cVar.f290659i;
        if (z16) {
            i3 = 5;
        } else {
            i3 = 3;
        }
        linearLayout3.setGravity(i3);
        cVar.f290658h.addView(cVar.f290659i, layoutParams6);
        if (!z16) {
        }
        it = this.U0.iterator();
        while (it.hasNext()) {
        }
        cVar.f290652b = this.X0;
        cVar.f290651a = z16;
        return F;
    }
}
