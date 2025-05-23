package ex4;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.action.MemeZPlanBatchAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0017H\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001aJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f2\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aR\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\"\u00a8\u0006&"}, d2 = {"Lex4/a;", "", "Lorg/json/JSONObject;", "memeZPlanActionJson", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "memeZPlanAction", "", h.F, "k", "coverJson", "Lcom/tencent/zplan/meme/model/BusinessConfig$Cover;", "g", "Lcom/tencent/zplan/meme/action/MODE;", "j", "Lcom/tencent/zplan/common/model/AppTheme;", "l", "i", "f", "actionJson", "memeAction", "b", "Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;", "c", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "a", "e", "", "d", "memeZPlanActionData", "", DomainData.DOMAIN_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Ljava/lang/String;", "TIME_STAMP", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f397351b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static String TIME_STAMP = String.valueOf(System.currentTimeMillis());

    a() {
    }

    private final void a(JSONObject actionJson, MemeZPlanBaseAction memeAction) {
        actionJson.put("width", memeAction.getWidth());
        actionJson.put("height", memeAction.getHeight());
        actionJson.put("mode", memeAction.getMode().name());
        actionJson.put("theme", memeAction.getTheme());
        actionJson.put("backgroundColor", memeAction.getConfig().getBackgroundColor());
        actionJson.put("camera", memeAction.getConfig().getCamera().f());
        actionJson.put("frameType", memeAction.getConfig().getFrameType());
        actionJson.put("timestamp", TIME_STAMP);
        actionJson.put("requestTime", System.currentTimeMillis());
        actionJson.put("AAType", memeAction.getConfig().getAaType());
        actionJson.put("AALevel", memeAction.getConfig().getAaLevel());
        actionJson.put("styleType", memeAction.getConfig().getActionStyle());
        actionJson.put("disableGlassesMetallic", memeAction.getConfig().getDisableGlassesMetallic());
    }

    private final void b(JSONObject actionJson, MemeZPlanAction memeAction) {
        boolean z16;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(memeAction.getPortraitId());
        JSONArray jSONArray2 = new JSONArray();
        String senderUin = memeAction.getSenderUin();
        boolean z17 = false;
        if (senderUin != null && senderUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            jSONArray2.mo162put(senderUin);
        }
        String receiverUin = memeAction.getReceiverUin();
        if (receiverUin != null) {
            if (receiverUin.length() > 0) {
                z17 = true;
            }
            if (z17) {
                jSONArray2.mo162put(receiverUin);
            }
        }
        actionJson.put("uins", jSONArray2);
        actionJson.put("portraitIds", jSONArray);
        a(actionJson, memeAction);
    }

    private final void c(JSONObject actionJson, MemeZPlanBatchAction memeAction) {
        boolean z16;
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = memeAction.getRealNeedRecordIds().iterator();
        while (it.hasNext()) {
            jSONArray.put(((Number) it.next()).intValue());
        }
        JSONArray jSONArray2 = new JSONArray();
        String senderUin = memeAction.getSenderUin();
        boolean z17 = false;
        if (senderUin != null && senderUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            jSONArray2.mo162put(senderUin);
        }
        String receiverUin = memeAction.getReceiverUin();
        if (receiverUin != null) {
            if (receiverUin.length() > 0) {
                z17 = true;
            }
            if (z17) {
                jSONArray2.mo162put(receiverUin);
            }
        }
        actionJson.put("uins", jSONArray2);
        actionJson.put("portraitIds", jSONArray);
        a(actionJson, memeAction);
    }

    private final void f(JSONObject memeZPlanActionJson, MemeZPlanAction memeZPlanAction) {
        JSONObject optJSONObject = memeZPlanActionJson.optJSONObject("camera");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("location");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            memeZPlanAction.getConfig().getCamera().a(optJSONObject2.toString());
            JSONObject optJSONObject3 = optJSONObject.optJSONObject(BasicAnimation.KeyPath.ROTATION);
            if (optJSONObject3 == null) {
                optJSONObject3 = new JSONObject();
            }
            memeZPlanAction.getConfig().getCamera().e(optJSONObject3.toString());
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("projection");
            if (optJSONObject4 == null) {
                optJSONObject4 = new JSONObject();
            }
            memeZPlanAction.getConfig().getCamera().b(optJSONObject4.toString());
        }
    }

    private final BusinessConfig.Cover g(JSONObject coverJson) {
        return new BusinessConfig.Cover(coverJson.optBoolean("enable", false), coverJson.optInt("index", 0));
    }

    private final void h(JSONObject memeZPlanActionJson, MemeZPlanAction memeZPlanAction) {
        JSONObject optJSONObject;
        if (memeZPlanActionJson.has("cover") && (optJSONObject = memeZPlanActionJson.optJSONObject("cover")) != null) {
            memeZPlanAction.getConfig().getMp4Config().j(f397351b.g(optJSONObject));
        }
    }

    private final void i(JSONObject memeZPlanActionJson, MemeZPlanAction memeZPlanAction) {
        boolean z16;
        BusinessConfig.FrameType frameType;
        String frameType2 = memeZPlanActionJson.optString("frameType");
        Intrinsics.checkNotNullExpressionValue(frameType2, "frameType");
        if (frameType2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            frameType = BusinessConfig.FrameType.valueOf(frameType2);
        } else {
            frameType = BusinessConfig.FrameType.PNG;
        }
        memeZPlanAction.getConfig().C(frameType);
    }

    private final MODE j(JSONObject memeZPlanActionJson) {
        boolean z16;
        String mode = memeZPlanActionJson.optString("mode");
        Intrinsics.checkNotNullExpressionValue(mode, "mode");
        if (mode.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return MODE.valueOf(mode);
        }
        return MODE.FRAME;
    }

    private final void k(JSONObject memeZPlanActionJson, MemeZPlanAction memeZPlanAction) {
        if (memeZPlanActionJson.has("AAType")) {
            memeZPlanAction.getConfig().w(Integer.valueOf(memeZPlanActionJson.optInt("AAType")));
        }
        if (memeZPlanActionJson.has("AALevel")) {
            memeZPlanAction.getConfig().v(Integer.valueOf(memeZPlanActionJson.optInt("AALevel")));
        }
    }

    private final AppTheme l(JSONObject memeZPlanActionJson) {
        boolean z16;
        String theme = memeZPlanActionJson.optString("theme");
        Intrinsics.checkNotNullExpressionValue(theme, "theme");
        if (theme.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return AppTheme.valueOf(theme);
        }
        return AppTheme.DAY;
    }

    @NotNull
    public final String d(@NotNull MemeZPlanBaseAction memeAction) {
        Intrinsics.checkNotNullParameter(memeAction, "memeAction");
        JSONObject jSONObject = new JSONObject();
        if (memeAction instanceof MemeZPlanAction) {
            b(jSONObject, (MemeZPlanAction) memeAction);
        } else if (memeAction instanceof MemeZPlanBatchAction) {
            c(jSONObject, (MemeZPlanBatchAction) memeAction);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "actionJson.toString()");
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "ActionDataHelper", 1, "build Result == " + jSONObject2, null, 8, null);
        }
        return jSONObject2;
    }

    @NotNull
    public final MemeZPlanAction e(@NotNull JSONObject memeZPlanActionJson) {
        int i3;
        String str;
        String str2;
        gx4.a aVar;
        gx4.a aVar2;
        int i16;
        String str3;
        AvatarCharacterInfo avatarCharacterInfo;
        AvatarCharacterInfo avatarCharacterInfo2;
        lx4.d a16;
        Intrinsics.checkNotNullParameter(memeZPlanActionJson, "memeZPlanActionJson");
        JSONArray optJSONArray = memeZPlanActionJson.optJSONArray("portraitIds");
        if (optJSONArray != null) {
            i3 = optJSONArray.getInt(0);
        } else {
            i3 = 0;
        }
        JSONArray optJSONArray2 = memeZPlanActionJson.optJSONArray("uins");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            Object obj = optJSONArray2.get(0);
            if (obj != null) {
                str = (String) obj;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            str = "0";
        }
        String str4 = str;
        if (optJSONArray2 != null && optJSONArray2.length() > 1) {
            Object obj2 = optJSONArray2.get(1);
            if (obj2 != null) {
                str2 = (String) obj2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            str2 = null;
        }
        int optInt = memeZPlanActionJson.optInt("width");
        int optInt2 = memeZPlanActionJson.optInt("height");
        MODE j3 = j(memeZPlanActionJson);
        AppTheme l3 = l(memeZPlanActionJson);
        int optInt3 = memeZPlanActionJson.optInt("backgroundColor");
        JSONArray optJSONArray3 = memeZPlanActionJson.optJSONArray("user_data_list");
        if (optJSONArray3 == null) {
            optJSONArray3 = new JSONArray();
        }
        if (optJSONArray3.length() > 0) {
            JSONObject jSONObject = optJSONArray3.getJSONObject(0);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "userDataListJsonArray.getJSONObject(0)");
            aVar = fx4.a.a(jSONObject);
        } else {
            aVar = null;
        }
        if (optJSONArray3.length() > 1) {
            JSONObject jSONObject2 = optJSONArray3.getJSONObject(1);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "userDataListJsonArray.getJSONObject(1)");
            aVar2 = fx4.a.a(jSONObject2);
        } else {
            aVar2 = null;
        }
        JSONArray optJSONArray4 = memeZPlanActionJson.optJSONArray("dressKeyList");
        if (optJSONArray4 == null) {
            optJSONArray4 = new JSONArray();
        }
        String str5 = "";
        if (optJSONArray4.length() > 0) {
            Object obj3 = optJSONArray4.get(0);
            if (obj3 != null) {
                i16 = optInt3;
                str3 = (String) obj3;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            i16 = optInt3;
            str3 = "";
        }
        if (optJSONArray4.length() > 1) {
            Object obj4 = optJSONArray4.get(1);
            if (obj4 != null) {
                str5 = (String) obj4;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        String str6 = str5;
        MODE mode = MODE.MP4;
        if (j3 == mode) {
            optInt = vx4.b.a(optInt);
        }
        if (j3 == mode) {
            optInt2 = vx4.b.a(optInt2);
        }
        if (aVar != null) {
            avatarCharacterInfo = new AvatarCharacterInfo(aVar, str3);
        } else {
            avatarCharacterInfo = null;
        }
        if (aVar2 != null) {
            avatarCharacterInfo2 = new AvatarCharacterInfo(aVar2, str6);
        } else {
            avatarCharacterInfo2 = null;
        }
        int optInt4 = memeZPlanActionJson.optInt("styleType", -1);
        boolean optBoolean = memeZPlanActionJson.optBoolean("disableGlassesMetallic", false);
        if (j3 == mode && (a16 = LogUtil.f385285b.a()) != null) {
            d.a.c(a16, "ActionDataHelper", 1, "buildMemeBatchActionWithJson, actionStyle:" + optInt4, null, 8, null);
        }
        MemeZPlanAction memeZPlanAction = new MemeZPlanAction(i3, j3.toFrameCount(), optInt, optInt2, j3, str4, str2, "", l3, null, null, avatarCharacterInfo, avatarCharacterInfo2, null, 9728, null);
        memeZPlanAction.getConfig().y(i16);
        memeZPlanAction.getConfig().x(optInt4);
        memeZPlanAction.getConfig().z(Boolean.valueOf(optBoolean));
        k(memeZPlanActionJson, memeZPlanAction);
        h(memeZPlanActionJson, memeZPlanAction);
        f(memeZPlanActionJson, memeZPlanAction);
        i(memeZPlanActionJson, memeZPlanAction);
        return memeZPlanAction;
    }

    @NotNull
    public final List<Integer> m(@NotNull String memeZPlanActionData) {
        boolean z16;
        List<Integer> emptyList;
        List<Integer> emptyList2;
        Intrinsics.checkNotNullParameter(memeZPlanActionData, "memeZPlanActionData");
        if (memeZPlanActionData.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        JSONArray optJSONArray = new JSONObject(memeZPlanActionData).optJSONArray("portraitIds");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(Integer.valueOf(optJSONArray.getInt(i3)));
        }
        return arrayList;
    }

    public final int n(@NotNull String memeZPlanActionData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(memeZPlanActionData, "memeZPlanActionData");
        if (memeZPlanActionData.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        return new JSONObject(memeZPlanActionData).optJSONArray("portraitIds").getInt(0);
    }

    @NotNull
    public final String o(@NotNull String memeZPlanActionData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(memeZPlanActionData, "memeZPlanActionData");
        if (memeZPlanActionData.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        String optString = new JSONObject(memeZPlanActionData).optString("mode");
        Intrinsics.checkNotNullExpressionValue(optString, "memeZPlanAction.optString(KEY_MODE)");
        return optString;
    }
}
