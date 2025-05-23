package fp;

import NS_MOBILE_DROPLIST.mobile_droplist_operate_rsp;
import NS_MOBILE_FEEDS.s_droplist_option;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    public C10330a f400205d;

    /* compiled from: P */
    /* renamed from: fp.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10330a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f400206a;

        /* renamed from: b, reason: collision with root package name */
        public String f400207b;

        /* renamed from: c, reason: collision with root package name */
        public String f400208c;

        public C10330a(boolean z16, String str, String str2) {
            this.f400206a = false;
            this.f400207b = l.a(R.string.ltd);
            l.a(R.string.ltc);
            this.f400206a = z16;
            this.f400207b = str;
            this.f400208c = str2;
        }
    }

    public a(s_droplist_option s_droplist_optionVar) {
        Map<String, String> map;
        if (s_droplist_optionVar == null || (map = s_droplist_optionVar.extend_info) == null || map.size() <= 0) {
            return;
        }
        boolean a16 = a(s_droplist_optionVar.action_detail, 2);
        Map<String, String> map2 = s_droplist_optionVar.extend_info;
        this.f400205d = new C10330a(a16, map2.get("success_text"), map2.get("fail_text"));
    }

    public boolean a(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        C10330a c10330a;
        if (qZoneTask == null || (c10330a = this.f400205d) == null || !c10330a.f400206a) {
            return;
        }
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            int i3 = ((mobile_droplist_operate_rsp) jceStruct).retCode;
            String str = ((mobile_droplist_operate_rsp) jceStruct).retMsg;
            if (i3 == 0) {
                ToastUtil.s(str, 5);
                return;
            } else {
                ToastUtil.s(str, 4);
                return;
            }
        }
        if (qZoneTask.succeeded()) {
            ToastUtil.s(this.f400205d.f400207b, 5);
        } else {
            ToastUtil.s(this.f400205d.f400208c, 4);
        }
    }
}
