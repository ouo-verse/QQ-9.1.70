package com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard;

import android.util.Base64;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.a;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$BasicProfileData;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$LabelInfo;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$QCircle;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$QZoneInfo;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$QcircleImg;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$Quest;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$RspBody;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$SelectedPicInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/f;", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/pb/oidb_0xe9b$RspBody;", "rspBody", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/a$b;", "c", "", "", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/a$e;", "g", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/a$d;", "f", "qCircleInfo", "ext", "", "i", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/a$c;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/a$f;", h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/a$a;", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/a;", "a", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "", "j", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final a.C7322a b(oidb_0xe9b$RspBody rspBody) {
        a.C7322a c7322a = new a.C7322a();
        PBRepeatMessageField<oidb_0xe9b$Quest> pBRepeatMessageField = rspBody.rpt_msg_quests;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() != 0) {
            oidb_0xe9b$Quest oidb_0xe9b_quest = rspBody.rpt_msg_quests.get(0);
            c7322a.f192064a = oidb_0xe9b_quest.str_id.get();
            c7322a.f192065b = oidb_0xe9b_quest.str_quest.get();
            c7322a.f192067d = oidb_0xe9b_quest.uint64_time.get();
            c7322a.f192066c = oidb_0xe9b_quest.uint64_quest_uin.get();
            c7322a.f192068e = oidb_0xe9b_quest.str_ans.get();
            return c7322a;
        }
        return null;
    }

    private final a.b c(oidb_0xe9b$RspBody rspBody) {
        oidb_0xe9b$BasicProfileData oidb_0xe9b_basicprofiledata = rspBody.msg_basic_profile.get();
        a.b bVar = new a.b();
        bVar.f192069a = oidb_0xe9b_basicprofiledata.uint32_age.get();
        bVar.f192070b = oidb_0xe9b_basicprofiledata.uint32_gender.get();
        bVar.f192071c = oidb_0xe9b_basicprofiledata.bytes_place.get().toStringUtf8();
        bVar.f192072d = oidb_0xe9b_basicprofiledata.bytes_addfrd_src.get().toStringUtf8();
        bVar.f192073e = oidb_0xe9b_basicprofiledata.uint32_comm_frd_num.get();
        return bVar;
    }

    private final List<a.c> d(oidb_0xe9b$RspBody rspBody) {
        List<oidb_0xe9b$SelectedPicInfo> list = rspBody.rpt_msg_selected_pic.get();
        ArrayList arrayList = new ArrayList();
        for (oidb_0xe9b$SelectedPicInfo oidb_0xe9b_selectedpicinfo : list) {
            a.c cVar = new a.c();
            cVar.f192074a = oidb_0xe9b_selectedpicinfo.str_ori_pic_url.get();
            cVar.f192075b = oidb_0xe9b_selectedpicinfo.str_medium_pic_url.get();
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private final List<String> e(oidb_0xe9b$RspBody rspBody) {
        List<oidb_0xe9b$LabelInfo> list = rspBody.rpt_msg_label.get();
        ArrayList arrayList = new ArrayList();
        Iterator<oidb_0xe9b$LabelInfo> it = list.iterator();
        while (it.hasNext()) {
            String stringUtf8 = it.next().bytes_name.get().toStringUtf8();
            Intrinsics.checkNotNullExpressionValue(stringUtf8, "personalLabelData.bytes_name.get().toStringUtf8()");
            arrayList.add(stringUtf8);
        }
        return arrayList;
    }

    private final a.d f(oidb_0xe9b$RspBody rspBody) {
        if (!rspBody.msg_circle_info.has()) {
            return null;
        }
        oidb_0xe9b$QCircle oidb_0xe9b_qcircle = rspBody.msg_circle_info.get();
        a.d dVar = new a.d();
        dVar.f192076a = new ArrayList();
        dVar.f192077b = new ArrayList();
        dVar.f192078c = new ArrayList();
        for (oidb_0xe9b$QcircleImg oidb_0xe9b_qcircleimg : oidb_0xe9b_qcircle.rpt_msg_imgs.get()) {
            dVar.f192076a.add(oidb_0xe9b_qcircleimg.str_url.get());
            dVar.f192077b.add(oidb_0xe9b_qcircleimg.str_jump.get());
            dVar.f192078c.add(Boolean.valueOf(oidb_0xe9b_qcircleimg.is_pic.get()));
        }
        String str = rspBody.msg_circle_info.ext.get();
        Intrinsics.checkNotNullExpressionValue(str, "rspBody.msg_circle_info.ext.get()");
        i(dVar, str);
        return dVar;
    }

    private final a.e g(oidb_0xe9b$RspBody rspBody) {
        if (!rspBody.msg_qzone_info.has()) {
            return null;
        }
        oidb_0xe9b$QZoneInfo oidb_0xe9b_qzoneinfo = rspBody.msg_qzone_info.get();
        a.e eVar = new a.e();
        eVar.f192080a = oidb_0xe9b_qzoneinfo.bytes_space_name.get().toStringUtf8();
        eVar.f192081b = oidb_0xe9b_qzoneinfo.bytes_update_content.get().toStringUtf8();
        Iterator<String> it = oidb_0xe9b_qzoneinfo.str_newly_img_url.get().iterator();
        while (it.hasNext()) {
            eVar.f192082c.add(it.next());
        }
        return eVar;
    }

    private final a.f h(oidb_0xe9b$RspBody rspBody) {
        boolean z16;
        a.f fVar = new a.f();
        List<ByteStringMicro> list = rspBody.rpt_bytes_longnick.get();
        if (list == null || list.size() == 0) {
            return null;
        }
        IMiniCardBeancurd iMiniCardBeancurd = (IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMiniCardBeancurd.class);
        boolean z17 = false;
        byte[] byteArray = list.get(0).toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "signData[0].toByteArray()");
        JSONObject signFromRichStatus = iMiniCardBeancurd.getSignFromRichStatus(byteArray);
        fVar.f192083a = signFromRichStatus.optInt("actionId", 0);
        fVar.f192084b = signFromRichStatus.optString(IMiniCardBeancurd.SIGN_ACTION_DATA, "");
        fVar.f192085c = signFromRichStatus.optString(IMiniCardBeancurd.SIGN_PLAIN_TEXT, "");
        String str = fVar.f192084b;
        Intrinsics.checkNotNullExpressionValue(str, "sign.actionAndData");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str2 = fVar.f192085c;
            Intrinsics.checkNotNullExpressionValue(str2, "sign.plainText");
            if (str2.length() == 0) {
                z17 = true;
            }
            if (z17) {
                return null;
            }
        }
        return fVar;
    }

    private final void i(a.d qCircleInfo, String ext) {
        boolean z16;
        if (ext.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                qCircleInfo.f192079d = new JSONObject(ext).getBoolean("qzone_first");
            } catch (Exception e16) {
                QLog.e("MiniCardParser", 1, e16, new Object[0]);
            }
        }
    }

    @NotNull
    public final a a(@NotNull oidb_0xe9b$RspBody rspBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rspBody);
        }
        Intrinsics.checkNotNullParameter(rspBody, "rspBody");
        a aVar = new a();
        aVar.f192057a = c(rspBody);
        aVar.f192058b.addAll(e(rspBody));
        aVar.f192059c = g(rspBody);
        aVar.f192060d.addAll(d(rspBody));
        aVar.f192061e = h(rspBody);
        aVar.f192062f = b(rspBody);
        aVar.f192063g = f(rspBody);
        return aVar;
    }

    public final boolean j(@NotNull ah message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(message, "message");
        String l26 = message.l2();
        if (l26 == null) {
            return true;
        }
        byte[] decode = Base64.decode(l26, 0);
        oidb_0xe9b$RspBody oidb_0xe9b_rspbody = new oidb_0xe9b$RspBody();
        oidb_0xe9b_rspbody.mergeFrom(decode);
        return new f().a(oidb_0xe9b_rspbody).a();
    }
}
