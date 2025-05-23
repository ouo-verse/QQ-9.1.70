package e82;

import android.content.Context;
import android.os.Bundle;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.matchfriend.reborn.utils.d;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$Tag;
import com.tencent.util.URLUtil;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JF\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0012\u001a\u00020\u0011\u00a8\u0006\u0015"}, d2 = {"Le82/a;", "", "", "openId", "Landroid/os/Bundle;", "a", "Landroid/content/Context;", "context", "", "sourceId", "fromPage", "params", "Le82/a$a;", ITVKPlayerEventListener.KEY_USER_INFO, "feedId", "", "c", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "b", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f395872a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u000e\u0010\bR*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Le82/a$a;", "", "", "a", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "avatar", "getNick", "f", "nick", "", "c", "Ljava/lang/Integer;", "getGender", "()Ljava/lang/Integer;", "e", "(Ljava/lang/Integer;)V", "gender", "d", "getDeclaration", "declaration", "getConstellation", LpReport_UserInfo_dc02148.CONSTELLATION, "", "Lcom/tencent/trpcprotocol/qqstranger/common/qqstranger_user_info/QqstrangerUserInfoPB$Tag;", "Ljava/util/List;", "getTags", "()Ljava/util/List;", "g", "(Ljava/util/List;)V", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e82.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10222a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String avatar;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String nick;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private Integer gender;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String declaration;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private String constellation;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private List<QqstrangerUserInfoPB$Tag> tags;

        public final String a() {
            JSONObject jSONObject = new JSONObject();
            String str = this.avatar;
            if (str != null) {
                jSONObject.put("avatar", URLUtil.encodeUrl(str));
            }
            Object obj = this.nick;
            if (obj != null) {
                jSONObject.put("nick", obj);
            }
            Integer num = this.gender;
            if (num != null) {
                jSONObject.put("gender", num.intValue());
            }
            Object obj2 = this.declaration;
            if (obj2 != null) {
                jSONObject.put("declaration", obj2);
            }
            Object obj3 = this.constellation;
            if (obj3 != null) {
                jSONObject.put(LpReport_UserInfo_dc02148.CONSTELLATION, obj3);
            }
            List<QqstrangerUserInfoPB$Tag> list = this.tags;
            if (!(list == null || list.isEmpty())) {
                JSONArray jSONArray = new JSONArray();
                List<QqstrangerUserInfoPB$Tag> list2 = this.tags;
                Intrinsics.checkNotNull(list2);
                for (QqstrangerUserInfoPB$Tag qqstrangerUserInfoPB$Tag : list2) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("tagId", qqstrangerUserInfoPB$Tag.tag_id.get());
                    jSONObject2.put("tagName", qqstrangerUserInfoPB$Tag.tag_name.get());
                    jSONArray.mo162put(jSONObject2);
                }
                jSONObject.put(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, jSONArray);
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.toString()");
            return jSONObject3;
        }

        public final void b(String str) {
            this.avatar = str;
        }

        public final void c(String str) {
            this.constellation = str;
        }

        public final void d(String str) {
            this.declaration = str;
        }

        public final void e(Integer num) {
            this.gender = num;
        }

        public final void f(String str) {
            this.nick = str;
        }

        public final void g(List<QqstrangerUserInfoPB$Tag> list) {
            this.tags = list;
        }
    }

    a() {
    }

    private final Bundle a(String openId) {
        Bundle bundle = new Bundle();
        bundle.putString("page_name", "nearby_new_homepage");
        bundle.putInt("bu_type", 1);
        bundle.putInt("self", 1);
        bundle.putString("tinyid", openId);
        bundle.putInt("from_id", 9);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("launchKuiklyParams", bundle);
        return bundle2;
    }

    public final QPublicBaseFragment b() {
        PBStringField pBStringField;
        QPublicBaseFragment createQQKuiklyFragment = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createQQKuiklyFragment();
        Object a16 = d.f245469a.a("loginUserInfoKey");
        String str = null;
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        if (userinfo_miniinfo != null && (pBStringField = userinfo_miniinfo.open_id) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            str = "";
        }
        QLog.i("QQStrangerProfileKuiklyLauncher", 1, "createFragment openId=" + str);
        createQQKuiklyFragment.setArguments(f395872a.a(str));
        return createQQKuiklyFragment;
    }

    public final void c(Context context, String openId, int sourceId, int fromPage, Bundle params, C10222a userInfo, String feedId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(params, "params");
        Object a16 = d.f245469a.a("selfOpenIDKey");
        String str = a16 instanceof String ? (String) a16 : null;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        boolean areEqual = Intrinsics.areEqual(openId, str);
        String addParameter = URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_modal_homepage&modal_mode=1&bu_type=1", "self", String.valueOf(areEqual ? 1 : 0)), "tinyid", openId), "from_id", String.valueOf(fromPage)), "source_id", String.valueOf(sourceId));
        if (feedId != null) {
            addParameter = URLUtil.addParameter(addParameter, "feed_id", feedId);
        }
        String string = params.getString("recom_trace");
        if (string != null) {
            if (string.length() > 0) {
                addParameter = URLUtil.addParameter(addParameter, "trace_id", string);
                str2 = string;
            }
        }
        if (userInfo != null) {
            String a17 = userInfo.a();
            QLog.i("QQStrangerProfileKuiklyLauncher", 1, "[launchHalfScreen] userInfoString=" + a17);
            addParameter = URLUtil.addParameter(addParameter, "user_info", a17);
        }
        QLog.i("QQStrangerProfileKuiklyLauncher", 1, "[launchHalfScreen] isSelf=" + (areEqual ? 1 : 0) + ", fromPage=" + fromPage + ", sourceId=" + sourceId + ", traceId=" + ((Object) str2));
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, addParameter);
    }
}
