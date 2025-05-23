package com.tencent.mobileqq.troop.teamup.publish.data;

import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpAttachment;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpContentItem;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpOption;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0000\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000*\u00028\u0000H\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\"\u0018\u0010\n\u001a\u00020\u0007*\u00020\u00068@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000b*\u00020\u00068@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpAttachment;", "T", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "c", "(Ljava/util/List;)Ljava/util/List;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;)Ljava/lang/String;", "content", "Lcom/tencent/mobileqq/troop/teamup/publish/data/TroopTeamUpJoinType;", "b", "(Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;)Lcom/tencent/mobileqq/troop/teamup/publish/data/TroopTeamUpJoinType;", "joinType", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpTemplateKt {
    @NotNull
    public static final String a(@NotNull TeamUpTemplate teamUpTemplate) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(teamUpTemplate, "<this>");
        ArrayList<TeamUpContentItem> contentList = teamUpTemplate.contentList;
        Intrinsics.checkNotNullExpressionValue(contentList, "contentList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : contentList) {
            boolean z16 = true;
            if (((TeamUpContentItem) obj).contentType != 1) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, TroopTeamUpTemplateKt$content$2.INSTANCE, 30, null);
        return joinToString$default;
    }

    @Nullable
    public static final TroopTeamUpJoinType b(@NotNull TeamUpTemplate teamUpTemplate) {
        Object obj;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(teamUpTemplate, "<this>");
        ArrayList<TeamUpOption> options = teamUpTemplate.options;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        Iterator<T> it = options.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((TeamUpOption) obj).optionId == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        TeamUpOption teamUpOption = (TeamUpOption) obj;
        if (teamUpOption == null || teamUpOption.optionType != 1) {
            return null;
        }
        for (TroopTeamUpJoinType troopTeamUpJoinType : TroopTeamUpJoinType.values()) {
            if (troopTeamUpJoinType.getProtoValue() == teamUpOption.optionValue.radioValue) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return troopTeamUpJoinType;
            }
        }
        return null;
    }

    @NotNull
    public static final <T extends List<? extends TeamUpAttachment>> List<BaseItem> c(@NotNull T t16) {
        ImageItem imageItem;
        Intrinsics.checkNotNullParameter(t16, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = t16.iterator();
        while (it.hasNext()) {
            TeamUpAttachment teamUpAttachment = (TeamUpAttachment) it.next();
            if (teamUpAttachment.attachmentType == 1) {
                imageItem = new ImageItem();
                imageItem.setHttpUrl(teamUpAttachment.img.picUrl);
                imageItem.setWidth(teamUpAttachment.img.width);
                imageItem.setHeight(teamUpAttachment.img.height);
                imageItem.setFileMd5(teamUpAttachment.img.md5);
            } else {
                imageItem = null;
            }
            if (imageItem != null) {
                arrayList.add(imageItem);
            }
        }
        return arrayList;
    }
}
