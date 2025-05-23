package com.tencent.qidian.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.proto.mobileqq_qidian$ConfigCorpSimpleInfo;
import com.tencent.qidian.proto.mobileqq_qidian$ConfigGroupInfo;
import com.tencent.qidian.proto.mobileqq_qidian$ConfigInfo;
import com.tencent.qidian.proto.mobileqq_qidian$GetCorpUinDetailInfoRspBody;
import com.tencent.qidian.proto.mobileqq_qidian$GetUserDetailInfoRspBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes22.dex */
public class QidianProfileUiInfo extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int CONFIG_INFO_EVENT_CALL_MOBILE = 2;
    public static final int CONFIG_INFO_EVENT_CALL_TEL = 1;
    public static final int CONFIG_INFO_EVENT_MAIL = 3;
    public static final int CONFIG_INFO_EVENT_NONE = 0;
    public static final int CONFIG_INFO_EVENT_OPEN_BROWSER = 6;
    public static final int CONFIG_INFO_EVENT_OPEN_MAP = 5;
    public static final int CONFIG_INFO_EVENT_PLUGIN_APP = 7;
    public static final int CONFIG_INFO_EVENT_QZONE = 9;
    public static final int CONFIG_INFO_EVENT_SHOW_ALL_TEXT = 4;
    public static final int CONFIG_INFO_TITLE_TYPE_ACCOUNT = 4;
    public static final int CONFIG_INFO_TITLE_TYPE_ADDRESS = 5;
    public static final int CONFIG_INFO_TITLE_TYPE_COMPANY = 7;
    public static final int CONFIG_INFO_TITLE_TYPE_DEFAULT = 0;
    public static final int CONFIG_INFO_TITLE_TYPE_ENTERPRISE_FULL_NAME = 11;
    public static final int CONFIG_INFO_TITLE_TYPE_LINK = 6;
    public static final int CONFIG_INFO_TITLE_TYPE_MAIL = 3;
    public static final int CONFIG_INFO_TITLE_TYPE_MOBILE = 2;
    public static final int CONFIG_INFO_TITLE_TYPE_PEOPLE = 8;
    public static final int CONFIG_INFO_TITLE_TYPE_QZONE = 10;
    public static final int CONFIG_INFO_TITLE_TYPE_RECOMMENDED_ATTENTION = 12;
    public static final int CONFIG_INFO_TITLE_TYPE_RECOMMENDED_GROUP = 13;
    public static final int CONFIG_INFO_TITLE_TYPE_SIGN = 9;
    public static final int CONFIG_INFO_TITLE_TYPE_TEL = 1;
    public static final int CONFIG_INFO_TYPE_GROUP = 3;
    public static final int CONFIG_INFO_TYPE_PA = 2;
    public static final int CONFIG_INFO_TYPE_QZONE = 6;
    public static final int CONFIG_INFO_TYPE_TEXT = 1;
    private static final String TAG = "QidianProfileUiInfo";
    public byte[] infoByte;
    public List<b> mConfigGroupInfos;

    @unique
    public String uin;

    /* loaded from: classes22.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f342854a;

        /* renamed from: b, reason: collision with root package name */
        public String f342855b;

        /* renamed from: c, reason: collision with root package name */
        public String f342856c;

        /* renamed from: d, reason: collision with root package name */
        public String f342857d;

        public a(mobileqq_qidian$ConfigCorpSimpleInfo mobileqq_qidian_configcorpsimpleinfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileqq_qidian_configcorpsimpleinfo);
                return;
            }
            this.f342854a = "";
            this.f342855b = "";
            this.f342856c = "";
            this.f342857d = "";
            if (mobileqq_qidian_configcorpsimpleinfo.str_corp_name.has()) {
                this.f342854a = mobileqq_qidian_configcorpsimpleinfo.str_corp_name.get();
            }
            if (mobileqq_qidian_configcorpsimpleinfo.str_short_name.has()) {
                this.f342855b = mobileqq_qidian_configcorpsimpleinfo.str_short_name.get();
            }
            if (mobileqq_qidian_configcorpsimpleinfo.str_detail_desc.has()) {
                this.f342856c = mobileqq_qidian_configcorpsimpleinfo.str_detail_desc.get();
            }
            if (mobileqq_qidian_configcorpsimpleinfo.str_click_url.has()) {
                this.f342857d = mobileqq_qidian_configcorpsimpleinfo.str_click_url.get();
            }
        }
    }

    public QidianProfileUiInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uin = "";
            this.mConfigGroupInfos = null;
        }
    }

    private void initList() {
        List<mobileqq_qidian$ConfigGroupInfo> list;
        List<mobileqq_qidian$ConfigGroupInfo> list2;
        try {
            QidianManager qidianManager = (QidianManager) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QIDIAN_MANAGER);
            if (this.infoByte != null) {
                if (!qidianManager.S(this.uin, true)) {
                    mobileqq_qidian$GetUserDetailInfoRspBody mobileqq_qidian_getuserdetailinforspbody = new mobileqq_qidian$GetUserDetailInfoRspBody();
                    mobileqq_qidian_getuserdetailinforspbody.mergeFrom(this.infoByte);
                    if (mobileqq_qidian_getuserdetailinforspbody.rpt_msg_config_group_info.has() && (list2 = mobileqq_qidian_getuserdetailinforspbody.rpt_msg_config_group_info.get()) != null && list2.size() > 0) {
                        this.infoByte = mobileqq_qidian_getuserdetailinforspbody.toByteArray();
                        this.mConfigGroupInfos = new ArrayList(list2.size());
                        Iterator<mobileqq_qidian$ConfigGroupInfo> it = list2.iterator();
                        while (it.hasNext()) {
                            this.mConfigGroupInfos.add(new b(it.next()));
                        }
                        return;
                    }
                    return;
                }
                mobileqq_qidian$GetCorpUinDetailInfoRspBody mobileqq_qidian_getcorpuindetailinforspbody = new mobileqq_qidian$GetCorpUinDetailInfoRspBody();
                mobileqq_qidian_getcorpuindetailinforspbody.mergeFrom(this.infoByte);
                if (mobileqq_qidian_getcorpuindetailinforspbody.rpt_msg_config_group_info.has() && (list = mobileqq_qidian_getcorpuindetailinforspbody.rpt_msg_config_group_info.get()) != null && list.size() > 0) {
                    this.infoByte = mobileqq_qidian_getcorpuindetailinforspbody.toByteArray();
                    this.mConfigGroupInfos = new ArrayList(list.size());
                    Iterator<mobileqq_qidian$ConfigGroupInfo> it5 = list.iterator();
                    while (it5.hasNext()) {
                        this.mConfigGroupInfos.add(new b(it5.next()));
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        return Arrays.equals(this.infoByte, ((QidianProfileUiInfo) obj).infoByte);
    }

    public void from(String str, mobileqq_qidian$GetUserDetailInfoRspBody mobileqq_qidian_getuserdetailinforspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) mobileqq_qidian_getuserdetailinforspbody);
            return;
        }
        this.uin = str;
        this.infoByte = mobileqq_qidian_getuserdetailinforspbody.toByteArray();
        initList();
    }

    public List<b> getConfigGroupInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.mConfigGroupInfos == null) {
            initList();
            if (this.mConfigGroupInfos == null) {
                this.mConfigGroupInfos = new ArrayList();
            }
        }
        return this.mConfigGroupInfos;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return Arrays.hashCode(this.infoByte);
    }

    /* loaded from: classes22.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public List<c> f342858a;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f342858a = null;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public b(mobileqq_qidian$ConfigGroupInfo mobileqq_qidian_configgroupinfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mobileqq_qidian_configgroupinfo);
                return;
            }
            this.f342858a = null;
            if (mobileqq_qidian_configgroupinfo.rpt_msg_config_info.has()) {
                List<mobileqq_qidian$ConfigInfo> list = mobileqq_qidian_configgroupinfo.rpt_msg_config_info.get();
                this.f342858a = new ArrayList(list.size());
                Iterator<mobileqq_qidian$ConfigInfo> it = list.iterator();
                while (it.hasNext()) {
                    this.f342858a.add(new c(it.next()));
                }
            }
        }
    }

    public void from(String str, mobileqq_qidian$GetCorpUinDetailInfoRspBody mobileqq_qidian_getcorpuindetailinforspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) mobileqq_qidian_getcorpuindetailinforspbody);
            return;
        }
        this.uin = str;
        this.infoByte = mobileqq_qidian_getcorpuindetailinforspbody.toByteArray();
        initList();
    }

    /* loaded from: classes22.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f342859a;

        /* renamed from: b, reason: collision with root package name */
        public int f342860b;

        /* renamed from: c, reason: collision with root package name */
        public String f342861c;

        /* renamed from: d, reason: collision with root package name */
        public String f342862d;

        /* renamed from: e, reason: collision with root package name */
        public String f342863e;

        /* renamed from: f, reason: collision with root package name */
        public String f342864f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f342865g;

        /* renamed from: h, reason: collision with root package name */
        public a f342866h;

        /* renamed from: i, reason: collision with root package name */
        public String f342867i;

        /* renamed from: j, reason: collision with root package name */
        public String f342868j;

        /* renamed from: k, reason: collision with root package name */
        public String f342869k;

        /* renamed from: l, reason: collision with root package name */
        public int f342870l;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f342859a = 1;
            this.f342860b = 0;
            this.f342861c = "";
            this.f342862d = "";
            this.f342863e = "";
            this.f342864f = "";
            this.f342865g = false;
            this.f342867i = "";
            this.f342868j = "";
            this.f342869k = "";
            this.f342870l = 0;
        }

        public c(mobileqq_qidian$ConfigInfo mobileqq_qidian_configinfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mobileqq_qidian_configinfo);
                return;
            }
            this.f342859a = 1;
            this.f342860b = 0;
            this.f342861c = "";
            this.f342862d = "";
            this.f342863e = "";
            this.f342864f = "";
            this.f342865g = false;
            this.f342867i = "";
            this.f342868j = "";
            this.f342869k = "";
            this.f342870l = 0;
            if (mobileqq_qidian_configinfo.uint32_type.has()) {
                this.f342859a = mobileqq_qidian_configinfo.uint32_type.get();
            }
            if (mobileqq_qidian_configinfo.uint32_event.has()) {
                this.f342860b = mobileqq_qidian_configinfo.uint32_event.get();
            }
            if (mobileqq_qidian_configinfo.str_title.has()) {
                this.f342861c = mobileqq_qidian_configinfo.str_title.get();
            }
            if (mobileqq_qidian_configinfo.str_content.has()) {
                this.f342862d = mobileqq_qidian_configinfo.str_content.get();
            }
            if (mobileqq_qidian_configinfo.str_action.has()) {
                this.f342863e = mobileqq_qidian_configinfo.str_action.get();
            }
            if (mobileqq_qidian_configinfo.str_aaction.has()) {
                this.f342864f = mobileqq_qidian_configinfo.str_aaction.get();
            }
            if (mobileqq_qidian_configinfo.msg_corp_simple.has()) {
                this.f342866h = new a(mobileqq_qidian_configinfo.msg_corp_simple);
            }
            if (mobileqq_qidian_configinfo.str_url.has()) {
                this.f342867i = mobileqq_qidian_configinfo.str_url.get();
            }
            if (mobileqq_qidian_configinfo.str_lat.has()) {
                this.f342868j = mobileqq_qidian_configinfo.str_lat.get();
            }
            if (mobileqq_qidian_configinfo.str_log.has()) {
                this.f342869k = mobileqq_qidian_configinfo.str_log.get();
            }
            if (mobileqq_qidian_configinfo.uint32_title_type.has()) {
                this.f342870l = mobileqq_qidian_configinfo.uint32_title_type.get();
            }
        }
    }
}
