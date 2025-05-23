package com.tencent.mobileqq.aio.msglist.holder.component.tofu;

import android.util.Base64;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.msg.TofuMsgDebugSwitch;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.h;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$BasicProfileData;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$LabelInfo;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$Quest;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$RspBody;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$SelectedPicInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import com.tencent.qqnt.kernel.nativeinterface.TofuRecordElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/h;", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\r2\u0006\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/h$a;", "", "", "g", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "data", "", "c", "Lorg/json/JSONObject;", "jsonObject", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuContent;", "e", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.h$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final void c(com.tencent.aio.api.runtime.a aioContext, String data) {
            try {
                AIOParam g16 = aioContext.g();
                Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
                QLog.d("DebugTofuMsgProcessor", 1, "for debug!!!!!!  insert tofu to uin:" + su3.c.a(g16));
                JSONObject jSONObject = new JSONObject(data);
                long optLong = jSONObject.optLong("busiid");
                String optString = jSONObject.optString("busi_uuid");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(BeancurdConst.KEY_BUSI_UUID)");
                int optInt = jSONObject.optInt("beancurd_style");
                JSONObject jSONObject2 = jSONObject.getJSONObject("description");
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.getJSONObject\u2026urdConst.KEY_DESCRIPTION)");
                TofuContent tofuContent = new TofuContent(jSONObject2.optString("detail"), jSONObject2.optString("color"));
                ArrayList<TofuContent> e16 = e(jSONObject);
                String optString2 = jSONObject.optString("background");
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(BeancurdConst.KEY_BACKGROUND)");
                String optString3 = jSONObject.optString("busiicon");
                Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(BeancurdConst.KEY_BUSIICON)");
                String optString4 = jSONObject.optString("busi_extra");
                Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(BeancurdConst.KEY_BUSI_EXTRA)");
                ArrayList<Long> f16 = f(jSONObject);
                new HashSet(f16);
                if (com.tencent.qqnt.msg.f.j() != null) {
                    final String j3 = aioContext.g().r().c().j();
                    ((IMsgService) QRoute.api(IMsgService.class)).addLocalTofuRecordMsg(new Contact(1, j3, ""), new TofuRecordElement(optLong, optString, optInt, tofuContent, e16, optString2, optString3, f16, optString4), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.g
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            h.Companion.d(j3, i3, str);
                        }
                    });
                }
            } catch (Exception e17) {
                QLog.d("DebugTofuMsgProcessor", 1, "for debug!!!!!!  doParse err: ", e17);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(String friendUid, int i3, String errMsg) {
            Intrinsics.checkNotNullParameter(friendUid, "$friendUid");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("DebugTofuMsgProcessor", 1, "for debug!!!!!!  insert debug-tofu to nt sdk\uff0cresult:" + i3 + ", errMsg:" + errMsg + ", friendUid:" + friendUid);
        }

        private final ArrayList<TofuContent> e(JSONObject jsonObject) throws JSONException {
            if (!jsonObject.has("content_list")) {
                return null;
            }
            JSONArray jSONArray = jsonObject.getJSONArray("content_list");
            ArrayList<TofuContent> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                arrayList.add(new TofuContent(jSONObject.optString("detail"), jSONObject.optString("color")));
            }
            return arrayList;
        }

        private final ArrayList<Long> f(JSONObject jsonObject) throws JSONException, NumberFormatException {
            ArrayList<Long> arrayList = new ArrayList<>();
            JSONArray jSONArray = jsonObject.getJSONArray("frd_uin");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String string = jSONArray.getString(i3);
                Intrinsics.checkNotNullExpressionValue(string, "uinJsonArray.getString(i)");
                arrayList.add(Long.valueOf(Long.parseLong(string)));
            }
            return arrayList;
        }

        private final String g() {
            oidb_0xe9b$RspBody oidb_0xe9b_rspbody = new oidb_0xe9b$RspBody();
            oidb_0xe9b_rspbody.uint64_next_req_interval.set(86400L);
            oidb_0xe9b$BasicProfileData oidb_0xe9b_basicprofiledata = new oidb_0xe9b$BasicProfileData();
            oidb_0xe9b_basicprofiledata.uint32_age.set(18);
            oidb_0xe9b_basicprofiledata.uint32_gender.set(2);
            oidb_0xe9b_basicprofiledata.bytes_place.set(ByteStringMicro.copyFromUtf8("\u4e2d\u5c71\u5927\u5b66"));
            oidb_0xe9b_basicprofiledata.bytes_addfrd_src.set(ByteStringMicro.copyFromUtf8("QQ\u53f7\u67e5\u627e"));
            oidb_0xe9b_basicprofiledata.uint32_comm_frd_num.set(10);
            oidb_0xe9b_rspbody.msg_basic_profile.set(oidb_0xe9b_basicprofiledata);
            oidb_0xe9b$LabelInfo oidb_0xe9b_labelinfo = new oidb_0xe9b$LabelInfo();
            oidb_0xe9b_labelinfo.bytes_name.set(ByteStringMicro.copyFromUtf8("11\u4e2a\u5171\u540c\u597d\u53cb"));
            oidb_0xe9b$LabelInfo oidb_0xe9b_labelinfo2 = new oidb_0xe9b$LabelInfo();
            oidb_0xe9b_labelinfo2.bytes_name.set(ByteStringMicro.copyFromUtf8("\u5728\u6df1\u5733"));
            oidb_0xe9b$LabelInfo oidb_0xe9b_labelinfo3 = new oidb_0xe9b$LabelInfo();
            oidb_0xe9b_labelinfo3.bytes_name.set(ByteStringMicro.copyFromUtf8("\u6469\u7faf\u5ea7"));
            oidb_0xe9b$LabelInfo oidb_0xe9b_labelinfo4 = new oidb_0xe9b$LabelInfo();
            oidb_0xe9b_labelinfo4.bytes_name.set(ByteStringMicro.copyFromUtf8("\u9526\u9ca4\u6563\u64ad\u673a"));
            oidb_0xe9b$LabelInfo oidb_0xe9b_labelinfo5 = new oidb_0xe9b$LabelInfo();
            oidb_0xe9b_labelinfo5.bytes_name.set(ByteStringMicro.copyFromUtf8("\u9526\u9ca4\u4f20\u9012\u5b98"));
            oidb_0xe9b$LabelInfo oidb_0xe9b_labelinfo6 = new oidb_0xe9b$LabelInfo();
            oidb_0xe9b_labelinfo6.bytes_name.set(ByteStringMicro.copyFromUtf8("\u6f6e\u642d\u7ec3\u4e60\u751f"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(oidb_0xe9b_labelinfo);
            arrayList.add(oidb_0xe9b_labelinfo2);
            arrayList.add(oidb_0xe9b_labelinfo3);
            arrayList.add(oidb_0xe9b_labelinfo4);
            arrayList.add(oidb_0xe9b_labelinfo5);
            arrayList.add(oidb_0xe9b_labelinfo6);
            oidb_0xe9b_rspbody.rpt_msg_label.set(arrayList);
            ArrayList arrayList2 = new ArrayList();
            oidb_0xe9b$SelectedPicInfo oidb_0xe9b_selectedpicinfo = new oidb_0xe9b$SelectedPicInfo();
            oidb_0xe9b_selectedpicinfo.str_ori_pic_url.set("http://ugc.qpic.cn/mqq_photo/0/2b03790ea30c78fa26e5f4b82df25e0922fedf3701/0");
            oidb_0xe9b_selectedpicinfo.str_medium_pic_url.set("http://ugc.qpic.cn/mqq_photo/0/2b03790ea30c78fa26e5f4b82df25e0922fedf3701/160");
            arrayList2.add(oidb_0xe9b_selectedpicinfo);
            oidb_0xe9b$SelectedPicInfo oidb_0xe9b_selectedpicinfo2 = new oidb_0xe9b$SelectedPicInfo();
            oidb_0xe9b_selectedpicinfo2.str_ori_pic_url.set("http://ugc.qpic.cn/mqq_photo/0/5ee20b618f8be6f5f10d552dfaa3572422fedf3701/0");
            oidb_0xe9b_selectedpicinfo2.str_medium_pic_url.set("http://ugc.qpic.cn/mqq_photo/0/5ee20b618f8be6f5f10d552dfaa3572422fedf3701/160");
            arrayList2.add(oidb_0xe9b_selectedpicinfo2);
            oidb_0xe9b_rspbody.rpt_msg_selected_pic.set(arrayList2);
            oidb_0xe9b$Quest oidb_0xe9b_quest = new oidb_0xe9b$Quest();
            oidb_0xe9b_quest.str_id.set("U_0b52186215060400545f3134335f393337343236343636");
            oidb_0xe9b_quest.str_quest.set("\u4f60\u611f\u89c9\u81ea\u5df1\u5728\u6253\u6e38\u620f\u65f6\u813e\u6c14\u5982\u4f55");
            oidb_0xe9b_quest.str_ans.set("\u975e\u5e38\u597d\u554a");
            oidb_0xe9b_quest.uint64_time.set(1645761035L);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(oidb_0xe9b_quest);
            oidb_0xe9b_rspbody.rpt_msg_quests.set(arrayList3);
            String encodeToString = Base64.encodeToString(oidb_0xe9b_rspbody.toByteArray(), 0);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(rspBody.t\u2026eArray(), Base64.DEFAULT)");
            return encodeToString;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final List<com.tencent.aio.data.msglist.a> b(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext, (Object) displayList);
            }
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            String str = "{\"busiid\":1,\"busi_uuid\":\"912600439532dc563905c04008b\",\"beancurd_style\":6,\"description\":{\"detail\":\"\u8ff7\u4f60\u8d44\u6599\u5361\u8c46\u8150\u5757\u6807\u9898\",\"color\":\"#878B99\"},\"background\":\"#FFFBEB\",\"content_list\":[{\"detail\":\"\u8ff7\u4f60\u8d44\u6599\u5361\u8c46\u8150\u5757\u5185\u5bb9\u3002\",\"color\":\"#03081A\"}],\"frd_uin\":[\"1290064532\"],\"busi_extra\":\"" + g() + "\"}";
            TofuMsgDebugSwitch.Companion companion = TofuMsgDebugSwitch.INSTANCE;
            if (companion.a() && (displayList instanceof ArrayList)) {
                QLog.d("DebugTofuMsgProcessor", 1, "for debug!!!!!!  insert tofu");
                companion.d(false);
                c(aioContext, "{\"busiid\":1,\"busi_uuid\":\"912600439532dc563905c04008b\",\"beancurd_style\":2,\"description\":{\"detail\":\"Text\u8c46\u8150\u5757\u6807\u9898\",\"color\":\"#111100\"},\"background\":\"#FFFBEB\",\"content_list\":[{\"detail\":\"Text\u5728\u7ebf\u72b6\u6001\u7b7e\u540d\u3002\",\"color\":\"#111100\"}],\"frd_uin\":[\"912600439\"]}");
                c(aioContext, "{\"busiid\":1,\"busi_uuid\":\"912600439532dc563905c04008b\",\"beancurd_style\":1,\"description\":{\"detail\":\"image\u8c46\u8150\u5757\u6807\u9898\",\"color\":\"#878B99\"},\"background\":\"#FFFBEB\",\"content_list\":[{\"detail\":\"\u56fe\u7247\u8c46\u8150\u5757\u5185\u5bb9\u3002\",\"color\":\"#03081A\"}],\"frd_uin\":[\"912600439\"]}");
                c(aioContext, "{\"busiid\":1,\"busi_uuid\":\"912600439532dc563905c04008b\",\"beancurd_style\":3,\"description\":{\"detail\":\"\u7cfb\u7edf\u901a\u77e5\u8c46\u8150\u5757\u6807\u9898\",\"color\":\"#878B99\"},\"background\":\"#FFFBEB\",\"content_list\":[{\"detail\":\"\u7cfb\u7edf\u901a\u77e5\u8c46\u8150\u5757\u5185\u5bb9\u3002\",\"color\":\"#03081A\"}],\"frd_uin\":[\"912600439\"]}");
                c(aioContext, "{\"busiid\":1,\"busi_uuid\":\"912600439532dc563905c04008b\",\"beancurd_style\":4,\"description\":{\"detail\":\"\u7cfb\u7edf\u901a\u77e5\u8c46\u8150\u5757\u6807\u9898\",\"color\":\"#878B99\"},\"background\":\"#FFFBEB\",\"content_list\":[{\"detail\":\"\u7cfb\u7edf\u901a\u77e5\u8c46\u8150\u5757\u5185\u5bb9\u3002\",\"color\":\"#03081A\"}],\"frd_uin\":[\"912600439\"]}");
                c(aioContext, str);
            }
            return displayList;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
