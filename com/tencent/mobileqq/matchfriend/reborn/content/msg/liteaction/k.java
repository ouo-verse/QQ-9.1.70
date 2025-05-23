package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0007j\b\u0012\u0004\u0012\u00020\u0004`\bH\u0002R'\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0007j\b\u0012\u0004\u0012\u00020\f`\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/k;", "", "", "index", "", "nickName", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "avatarConfigs", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$b;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "Ljava/util/ArrayList;", "getModels", "()Ljava/util/ArrayList;", IQQGameCommApi.K_ABTEST_MODELS, "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<QQStrangerLiteActionModel> models = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        IntRange until;
        int random;
        String str;
        int random2;
        int i3;
        String str2;
        ArrayList<String> arrayList = new ArrayList<>();
        com.tencent.mobileqq.matchfriend.reborn.config.c cVar = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a;
        arrayList.addAll(cVar.c().e());
        arrayList.addAll(cVar.c().c());
        Collections.shuffle(arrayList);
        int size = cVar.c().g().size();
        int size2 = arrayList.size();
        int i16 = 0;
        int i17 = 0;
        while (i17 < size2) {
            com.tencent.mobileqq.matchfriend.reborn.config.c cVar2 = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a;
            List<String> g16 = cVar2.c().g();
            until = RangesKt___RangesKt.until(i16, size);
            Random.Companion companion = Random.INSTANCE;
            random = RangesKt___RangesKt.random(until, companion);
            String str3 = g16.get(random);
            ArrayList<QQStrangerLiteActionModel> arrayList2 = this.models;
            String valueOf = String.valueOf(i17);
            int i18 = i17 >= 2 ? 1 : i16;
            String selfOpenId = com.tencent.mobileqq.matchfriend.utils.b.d().j();
            String str4 = arrayList.get(i17);
            String str5 = cVar2.c().g().get(i17 % size);
            String b16 = b(i17, str3);
            if (i17 >= 5) {
                str = "06-14";
            } else {
                str = "09-27";
            }
            String str6 = str;
            int i19 = i17 < 5 ? 49 : i17 < 10 ? 181 : 341;
            QQStrangerLiteActionModel.MsgInfo a16 = a(i17, arrayList);
            random2 = RangesKt___RangesKt.random(new IntRange(i16, 1), companion);
            boolean z16 = random2 == 1 ? 1 : i16;
            if (i17 == 0) {
                i3 = 2;
            } else {
                int i26 = 6;
                if (i17 <= 6) {
                    i26 = RangesKt___RangesKt.random(new IntRange(1, 5), companion);
                } else {
                    if (7 <= i17 && i17 < 13) {
                        i3 = 7;
                    } else {
                        if (13 <= i17 && i17 < 16) {
                            i26 = 8;
                        }
                    }
                }
                i3 = i26;
            }
            boolean z17 = i17 == 7 || i17 == 10 || i17 == 15;
            if (i17 <= 5) {
                str2 = "\u1f613\u6211\u559c\u6b22\u53bb\u56fe\u4e66";
            } else {
                str2 = "\u1f613\u4e00\u8d77\u5f00\u9ed1";
            }
            QQStrangerLiteActionModel.InteractiveOption interactiveOption = new QQStrangerLiteActionModel.InteractiveOption(false, str2, 0, 5, null);
            Intrinsics.checkNotNullExpressionValue(selfOpenId, "selfOpenId");
            Intrinsics.checkNotNullExpressionValue(str4, "avatarConfigs[i]");
            arrayList2.add(new QQStrangerLiteActionModel(valueOf, i18, selfOpenId, 0L, str4, str5, b16, str6, i19, 0L, i3, a16, z16, z17, interactiveOption, 8, null));
            i17++;
            i16 = 0;
        }
    }

    private final String b(int index, String nickName) {
        if (index >= 0 && index < 4) {
            return "\u7ed9\u4f60\u53d1\u9001\u4e86\u4e00\u4e2a\u6233\u6233";
        }
        if (4 <= index && index < 7) {
            return "TA \u56de\u5e94\u4e86\u4f60\u7684\u540c\u9891\u4e92\u52a8";
        }
        if (index == 7 || index == 10 || index == 15) {
            return "#highlight{\u3010\u8bc4\u8bba\u5df2\u5220\u9664\u3011}";
        }
        if (8 <= index && index < 10) {
            return "\u8bc4\u8bba\uff1a\u771f\u662f\u4e00\u53ea\u597d\u53ef\u7231\u7684\u67ef\u57fa\u554a";
        }
        if (11 <= index && index < 13) {
            return "\u56de\u590d\u4e86#highlight{" + nickName + "\u1f613}\uff1a\u771f\u662f\u4e00\u53ea\u597d\u53ef\u7231\u7684\u67ef\u57fa\u554a\u554a\u554a\u554a\u1f613\u1f608\u1f327\u1f35a";
        }
        if (index != 13) {
            if (index == 14) {
                return "\u56de\u590d\u4e86\u4f60\uff1a\u771f\u662f\u4e00\u53ea\u597d\u53ef\u7231\u7684\u67ef\u57fa\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554aaa\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a";
            }
            return "\u8d5e\u4e86\u4f60\u7684\u52a8\u6001";
        }
        return "\u56de\u590d\u4e86#highlight{" + nickName + "}\uff1a\u771f\u662f\u4e00\u53ea\u597d\u53ef\u7231\u7684\u67ef\u57fa\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a";
    }

    private final QQStrangerLiteActionModel.MsgInfo a(int index, ArrayList<String> avatarConfigs) {
        String str;
        IntRange until;
        int random;
        int i3 = index <= 5 ? 1 : 0;
        if (index >= 7 && index != 14) {
            until = RangesKt___RangesKt.until(0, avatarConfigs.size());
            random = RangesKt___RangesKt.random(until, Random.INSTANCE);
            str = avatarConfigs.get(random);
        } else {
            str = "";
        }
        String str2 = str;
        boolean z16 = index == 3 || index == 10;
        Intrinsics.checkNotNullExpressionValue(str2, "if (index >= 7 && index \u2026         \"\"\n            }");
        return new QQStrangerLiteActionModel.MsgInfo("", i3, "\u5c0f\u65f6\u5019\uff0c\u1f613\u1f608\u1f327\u1f35a\u6211\u559c\u6b22\u53bb\u56fe\u4e66\u9986\uff0c\u7136\u540e\u4e00\u5750\u5c31\u662f\u4e00\u6574\u5929\uff0c\u771f\u597d\uff01", str2, "", null, null, null, z16, 224, null);
    }
}
