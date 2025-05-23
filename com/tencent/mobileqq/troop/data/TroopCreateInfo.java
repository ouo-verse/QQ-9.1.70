package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@PluginInterface
/* loaded from: classes19.dex */
public class TroopCreateInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int INVALID_TROOP_CLASSIFY = 0;
    public static final int INVALID_TROOP_TYPE = -1;
    private static final String TAG = "TroopCreateInfo";
    public static final int TROOP_TYPE_200 = 1;
    public String classificationInfo;
    public int classify;
    public int createFrom;
    public String createScene;
    public String disPlayTroopName;
    public int groupUin;
    public boolean hasAddGrayTips;
    public boolean hasTroopHead;
    public String introduction;
    public List<a> inviteMembers;
    public boolean isJumpAio;
    public String location;
    public long maxSeq;
    public String name;
    public int newCreateFrom;
    public b sceneCallback;
    public String sceneTargetId;
    public byte[] signOriginal;
    public int troopSize;
    public int troopType;
    public String troopUin;
    public int verifyType;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(String str, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        public static int a(int i3) {
            if (i3 == 0) {
                return 0;
            }
            if (i3 != 70 && i3 != 7) {
                if (i3 != 97 && i3 != 9) {
                    if (i3 != 98 && i3 != 10) {
                        if (i3 != 101 && i3 != 11 && i3 != 102 && i3 != 103 && i3 != 14) {
                            if (i3 != 105 && i3 != 16) {
                                if (i3 == 21) {
                                    return R.string.dqr;
                                }
                                return R.string.dqv;
                            }
                            return R.string.dqt;
                        }
                        return R.string.dqu;
                    }
                    return R.string.dqw;
                }
                return R.string.dqs;
            }
            return R.string.dqx;
        }
    }

    public TroopCreateInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.createFrom = 0;
        this.newCreateFrom = 7;
        this.inviteMembers = Collections.synchronizedList(new ArrayList());
        reset();
    }

    public String attachCreateScene(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(this.createScene) && !str.contains("createScene=")) {
            str = str + "&createScene=" + this.createScene;
        }
        if (!TextUtils.isEmpty(this.sceneTargetId) && !str.contains("sceneTargetId=")) {
            return str + "&sceneTargetId=" + this.sceneTargetId;
        }
        return str;
    }

    public void parseFromJsonString(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.classify = jSONObject.optInt("classify", 0);
            this.verifyType = jSONObject.optInt("verifyType", 2);
            this.classificationInfo = jSONObject.optString("classificationInfo", "");
            this.name = jSONObject.optString("name", "");
            this.introduction = jSONObject.optString("introduction", "");
            this.location = jSONObject.optString("location", "");
            this.troopType = jSONObject.optInt("group_type", -1);
            boolean z16 = true;
            if (jSONObject.optInt("isJumpAio") != 1) {
                z16 = false;
            }
            this.isJumpAio = z16;
            this.createFrom = jSONObject.optInt("create_source", 0);
            this.newCreateFrom = jSONObject.optInt("new_create_source", 7);
            this.createScene = jSONObject.optString("createScene", this.createScene);
            this.sceneTargetId = jSONObject.optString("sceneTargetId", this.sceneTargetId);
        } catch (JSONException e16) {
            Log.e(TAG, "parseFromJsonString exception: ", e16);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.signOriginal = new byte[0];
        this.classify = 0;
        this.verifyType = 0;
        this.classificationInfo = "";
        this.name = "";
        this.introduction = "";
        this.location = "";
        this.troopSize = 1;
        this.troopType = -1;
        this.hasTroopHead = false;
        List<a> list = this.inviteMembers;
        if (list != null) {
            list.clear();
        }
        this.hasAddGrayTips = false;
        this.isJumpAio = false;
        this.maxSeq = 0L;
    }

    public void setCreateScene(String str, String str2, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, bVar);
            return;
        }
        this.createScene = str;
        this.sceneTargetId = str2;
        this.sceneCallback = bVar;
    }

    public void setCreateScene(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.createScene = str;
        this.sceneTargetId = "";
        this.sceneCallback = null;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f294787a;

        /* renamed from: b, reason: collision with root package name */
        public String f294788b;

        /* renamed from: c, reason: collision with root package name */
        public String f294789c;

        /* renamed from: d, reason: collision with root package name */
        public int f294790d;

        /* renamed from: e, reason: collision with root package name */
        public int f294791e;

        /* renamed from: f, reason: collision with root package name */
        public String f294792f;

        /* renamed from: g, reason: collision with root package name */
        public TroopMemberNickInfo f294793g;

        /* renamed from: h, reason: collision with root package name */
        public String f294794h;

        /* renamed from: i, reason: collision with root package name */
        public long f294795i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f294796j;

        /* renamed from: k, reason: collision with root package name */
        public String f294797k;

        public a(String str, String str2, int i3, int i16, String str3, String str4, long j3, boolean z16, String str5, TroopMemberNickInfo troopMemberNickInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3, str4, Long.valueOf(j3), Boolean.valueOf(z16), str5, troopMemberNickInfo);
                return;
            }
            this.f294787a = str;
            this.f294789c = str2;
            this.f294790d = i3;
            this.f294791e = i16;
            this.f294792f = str3;
            this.f294794h = str4;
            this.f294795i = j3;
            this.f294796j = z16;
            this.f294797k = str5;
            this.f294793g = troopMemberNickInfo;
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f294791e = -1;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }
}
