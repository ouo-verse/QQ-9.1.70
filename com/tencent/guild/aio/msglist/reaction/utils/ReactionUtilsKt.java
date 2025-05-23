package com.tencent.guild.aio.msglist.reaction.utils;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.msglist.text.util.b;
import com.tencent.guild.aio.msglist.text.util.f;
import com.tencent.guild.aio.util.ex.d;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AttaReportData;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesForRoleCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgService;
import gq0.EmojiReactionItem;
import gq0.EmojiTaskItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\u001a\u0016\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0000*\u00020\b\u001a\u0012\u0010\r\u001a\u00020\f*\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u001a\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u001a\u001a\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019*\u00020\u0016\u001a\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0000\u001a\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0000\u001aH\u0010(\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010%\u001a \u0010,\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u0006\u001a\u000e\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\n\"\"\u00104\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\"+\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0017j\b\u0012\u0004\u0012\u00020\u0000`\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u00105\u001a\u0004\b6\u00107\"+\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0017j\b\u0012\u0004\u0012\u00020\u0000`\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u00105\u001a\u0004\b9\u00107\u00a8\u0006;"}, d2 = {"", "localId", "type", "a", "serverId", "b", "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "Lgq0/b;", "o", "Landroid/content/res/Resources;", "resource", "", "isAttachToSelfSendMsg", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/GradientDrawable;", "f", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Ljava/util/ArrayList;", "Lgq0/c;", "Lkotlin/collections/ArrayList;", "g", "emojiType", "d", "", "count", "j", "emojiId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "taskType", "bClicked", "isGuest", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesForRoleCallback;", "cb", "", "l", "result", "retCode", "retMsg", DomainData.DOMAIN_NAME, "msgRecord", "k", "J", h.F, "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(J)V", "lastClickTime", "Lkotlin/Lazy;", "getFILTER_SYS_DATA", "()Ljava/util/ArrayList;", "FILTER_SYS_DATA", "getFILTER_EMOJI_DATA", "FILTER_EMOJI_DATA", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class ReactionUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    private static long f111859a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f111860b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy f111861c;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<Integer>>() { // from class: com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt$FILTER_SYS_DATA$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<Integer> invoke() {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(40);
                arrayList.add(19);
                arrayList.add(43);
                arrayList.add(20);
                arrayList.add(106);
                arrayList.add(24);
                arrayList.add(0);
                arrayList.add(33);
                arrayList.add(32);
                arrayList.add(13);
                arrayList.add(22);
                arrayList.add(3);
                arrayList.add(30);
                arrayList.add(83);
                arrayList.add(84);
                arrayList.add(39);
                arrayList.add(78);
                arrayList.add(48);
                arrayList.add(90);
                arrayList.add(41);
                arrayList.add(91);
                arrayList.add(164);
                arrayList.add(170);
                arrayList.add(169);
                arrayList.add(263);
                arrayList.add(283);
                arrayList.add(286);
                arrayList.add(288);
                arrayList.add(300);
                arrayList.add(301);
                arrayList.add(323);
                arrayList.add(311);
                arrayList.add(312);
                arrayList.add(317);
                arrayList.add(325);
                arrayList.add(92);
                arrayList.add(57);
                arrayList.add(179);
                arrayList.add(118);
                arrayList.add(74);
                arrayList.add(177);
                arrayList.add(109);
                arrayList.add(63);
                arrayList.add(72);
                arrayList.add(53);
                arrayList.add(153);
                arrayList.add(151);
                arrayList.add(149);
                arrayList.add(143);
                arrayList.add(185);
                arrayList.add(160);
                arrayList.add(159);
                arrayList.add(147);
                arrayList.add(155);
                arrayList.add(292);
                arrayList.add(198);
                arrayList.add(187);
                arrayList.add(209);
                arrayList.add(207);
                arrayList.add(189);
                arrayList.add(193);
                arrayList.add(197);
                arrayList.add(213);
                arrayList.add(210);
                arrayList.add(201);
                arrayList.add(188);
                arrayList.add(190);
                arrayList.add(205);
                arrayList.add(216);
                arrayList.add(195);
                arrayList.add(203);
                arrayList.add(196);
                arrayList.add(211);
                arrayList.add(202);
                arrayList.add(7);
                arrayList.add(17);
                arrayList.add(70);
                arrayList.add(141);
                arrayList.add(15);
                arrayList.add(96);
                arrayList.add(Integer.valueOf(AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE));
                arrayList.add(329);
                return arrayList;
            }
        });
        f111860b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<Integer>>() { // from class: com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt$FILTER_EMOJI_DATA$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<Integer> invoke() {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(10);
                arrayList.add(18);
                arrayList.add(26);
                arrayList.add(27);
                arrayList.add(31);
                arrayList.add(33);
                arrayList.add(57);
                arrayList.add(67);
                arrayList.add(80);
                arrayList.add(81);
                arrayList.add(91);
                arrayList.add(101);
                arrayList.add(106);
                arrayList.add(107);
                arrayList.add(108);
                arrayList.add(111);
                arrayList.add(121);
                arrayList.add(143);
                arrayList.add(162);
                return arrayList;
            }
        });
        f111861c = lazy2;
    }

    public static final int a(int i3, int i16) {
        return ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).localToServer(String.valueOf(i3), i16);
    }

    public static final int b(int i3, int i16) {
        return ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).serverToLocal(String.valueOf(i3), i16);
    }

    public static final int c(@NotNull String serverId, int i3) {
        Intrinsics.checkNotNullParameter(serverId, "serverId");
        return ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).serverToLocal(serverId, i3);
    }

    @Nullable
    public static final Drawable d(int i3, int i16) {
        Drawable.ConstantState constantState;
        if (i3 < 0) {
            QLog.i("ReactionUtils", 1, "getEmojiDrawable localId=" + i3 + ", emojiType: " + i16 + ", invalid localId!");
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append("_");
        sb5.append(i16);
        up0.a aVar = up0.a.f439407a;
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        Object e16 = aVar.e("TAG_EMOJI_REACTION_CACHE", sb6);
        if (e16 != null && (e16 instanceof Drawable) && (constantState = ((Drawable) e16).getConstantState()) != null) {
            return constantState.newDrawable().mutate();
        }
        Drawable emojiDrawable = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmojiDrawable(i3, i16, ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).isDynamicResReady(i3, i16));
        if (emojiDrawable == null) {
            QLog.i("ReactionUtils", 1, "getEmojiDrawable localId=" + i3 + ", emojiType: " + i16 + ", failed to get drawable!");
        } else {
            String sb7 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
            aVar.b("TAG_EMOJI_REACTION_CACHE", sb7, emojiDrawable);
        }
        return emojiDrawable;
    }

    @NotNull
    public static final Drawable e(@NotNull Resources resource, boolean z16) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        if (!UIUtil.f112434a.A()) {
            return f(resource);
        }
        Bitmap value = f.f111944a.c(z16).getValue();
        if (value != null) {
            b bVar = new b(value);
            wr0.a aVar = wr0.a.f446116a;
            bVar.c(aVar.c(4.0f));
            b bVar2 = new b(value);
            bVar2.c(aVar.c(4.0f));
            bVar2.setAlpha(127);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, bVar2);
            stateListDrawable.addState(new int[0], bVar);
            return stateListDrawable;
        }
        return f(resource);
    }

    private static final GradientDrawable f(Resources resources) {
        int color = ResourcesCompat.getColor(resources, com.tencent.mobileqq.R.color.qui_common_fill_standard_quaternary, null);
        int color2 = ResourcesCompat.getColor(resources, com.tencent.mobileqq.R.color.qui_common_fill_standard_primary, null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(wr0.a.f446116a.c(4.0f));
        gradientDrawable.setColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{color, color2}));
        return gradientDrawable;
    }

    @NotNull
    public static final ArrayList<EmojiTaskItem> g(@NotNull GuildMsgItem guildMsgItem) {
        Object firstOrNull;
        boolean z16;
        Object first;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        MsgElement msgElement = (MsgElement) firstOrNull;
        int i3 = 0;
        if (msgElement != null && msgElement.elementType == 10) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ArrayList<MsgElement> arrayList2 = guildMsgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.elements");
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
            try {
                JSONObject jSONObject2 = new JSONObject(((MsgElement) first).arkElement.bytesData);
                if (TextUtils.equals("com.tencent.manage.emotion.role", jSONObject2.optString("app"))) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
                    if (optJSONObject != null) {
                        jSONObject = optJSONObject.optJSONObject("detail");
                    } else {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        ArrayList<EmojiTaskItem> arrayList3 = new ArrayList<>();
                        long j3 = jSONObject.getLong("task_id");
                        long j16 = jSONObject.getLong("task_type");
                        boolean z17 = jSONObject.getBoolean("multiple");
                        JSONArray jSONArray = jSONObject.getJSONArray("select_list");
                        int length = jSONArray.length();
                        while (i3 < length) {
                            Object obj = jSONArray.get(i3);
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                            JSONObject jSONObject3 = (JSONObject) obj;
                            String emojiId = jSONObject3.getString("emoji_id");
                            int i16 = jSONObject3.getInt("emoji_type");
                            Intrinsics.checkNotNullExpressionValue(emojiId, "emojiId");
                            JSONArray jSONArray2 = jSONArray;
                            int i17 = length;
                            arrayList3.add(new EmojiTaskItem(j3, j16, z17, c(emojiId, i16), i16, guildMsgItem.getMsgRecord(), false, 0L, 192, null));
                            i3++;
                            jSONArray = jSONArray2;
                            length = i17;
                        }
                        return arrayList3;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public static final long h() {
        return f111859a;
    }

    public static final int i(@NotNull MsgEmojiLikes msgEmojiLikes) {
        Intrinsics.checkNotNullParameter(msgEmojiLikes, "<this>");
        String emojiId = msgEmojiLikes.emojiId;
        Intrinsics.checkNotNullExpressionValue(emojiId, "emojiId");
        return c(emojiId, (int) msgEmojiLikes.emojiType);
    }

    @NotNull
    public static final String j(long j3) {
        if (j3 < 0) {
            return "0";
        }
        if (j3 < 1000) {
            return String.valueOf(j3);
        }
        if (j3 < 10000) {
            return (j3 / 1000) + "k";
        }
        if (j3 < 10000000) {
            return (j3 / 10000) + "w";
        }
        return (j3 / 10000000) + "kw";
    }

    public static final boolean k(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgRecord.msgType != 9 && msgRecord.commentCnt > 0) {
            return true;
        }
        return false;
    }

    public static final void l(@NotNull MsgRecord msg2, @NotNull String emojiId, long j3, long j16, long j17, boolean z16, boolean z17, @Nullable ISetMsgEmojiLikesForRoleCallback iSetMsgEmojiLikesForRoleCallback) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(emojiId, "emojiId");
        AttaReportData attaReportData = new AttaReportData();
        attaReportData.sgrpSessionId = com.tencent.mobileqq.guild.report.b.e();
        attaReportData.sgrpVisitFrom = com.tencent.mobileqq.guild.report.b.f();
        attaReportData.sgrpStreamPginSourceName = com.tencent.mobileqq.guild.report.b.c();
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgEmojiLikesForRole(d.c(msg2), msg2.msgSeq, emojiId, j3, j16, j17, z16, z17, attaReportData, iSetMsgEmojiLikesForRoleCallback);
    }

    public static final void m(long j3) {
        f111859a = j3;
    }

    public static final void n(int i3, long j3, @Nullable String str) {
        if (i3 == 0) {
            if (j3 == 1) {
                QQToast.makeText(BaseApplication.getContext(), 2, str, 0).show();
                return;
            } else {
                if (j3 == 2) {
                    QQToast.makeText(BaseApplication.getContext(), 0, str, 0).show();
                    return;
                }
                return;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
            return;
        }
        if (i3 == 65008) {
            g.c(0, com.tencent.mobileqq.R.string.f143490m8);
        } else if (i3 == 99001) {
            g.c(1, com.tencent.mobileqq.R.string.f143470m6);
        } else if (i3 == 99002) {
            g.c(1, com.tencent.mobileqq.R.string.f143460m5);
        }
    }

    @NotNull
    public static final EmojiReactionItem o(@NotNull MsgEmojiLikes msgEmojiLikes, @NotNull MsgRecord msg2) {
        Intrinsics.checkNotNullParameter(msgEmojiLikes, "<this>");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new EmojiReactionItem(msgEmojiLikes.isClicked, (int) msgEmojiLikes.emojiType, msgEmojiLikes.likesCnt, i(msgEmojiLikes), msg2);
    }
}
