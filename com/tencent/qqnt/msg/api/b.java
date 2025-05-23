package com.tencent.qqnt.msg.api;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.data.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0018H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/msg/api/b;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onRecvMsg", "Lcom/tencent/qqnt/msg/data/h;", "sysData", "a", "", "byteArray", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGuildNotifyInfo;", "notifyInfo", "onGroupGuildUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/FirstViewGroupGuildInfo;", "firstViewGroupGuildInfos", "onFirstViewGroupGuildMapping", "", "flag", "onRecvUDCFlag", "onRecvGroupGuildFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/GuildMsgAbFlag;", "onGuildMsgAbFlagChanged", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {
    void a(@NotNull h sysData);

    void b(@NotNull byte[] byteArray);

    void onFirstViewGroupGuildMapping(@NotNull ArrayList<FirstViewGroupGuildInfo> firstViewGroupGuildInfos);

    void onGroupGuildUpdate(@NotNull GroupGuildNotifyInfo notifyInfo);

    void onGuildMsgAbFlagChanged(@NotNull GuildMsgAbFlag flag);

    void onRecvGroupGuildFlag(int flag);

    void onRecvMsg(@NotNull ArrayList<MsgRecord> msgList);

    void onRecvUDCFlag(int flag);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @NotNull ArrayList<FirstViewGroupGuildInfo> firstViewGroupGuildInfos) {
            Intrinsics.checkNotNullParameter(firstViewGroupGuildInfos, "firstViewGroupGuildInfos");
        }

        public static void b(@NotNull b bVar, @NotNull GroupGuildNotifyInfo notifyInfo) {
            Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
        }

        public static void c(@NotNull b bVar, @NotNull GuildMsgAbFlag flag) {
            Intrinsics.checkNotNullParameter(flag, "flag");
        }

        public static void e(@NotNull b bVar, @NotNull ArrayList<MsgRecord> msgList) {
            Intrinsics.checkNotNullParameter(msgList, "msgList");
        }

        public static void g(@NotNull b bVar, @NotNull byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        }

        public static void h(@NotNull b bVar, @NotNull h sysData) {
            Intrinsics.checkNotNullParameter(sysData, "sysData");
        }

        public static void d(@NotNull b bVar, int i3) {
        }

        public static void f(@NotNull b bVar, int i3) {
        }
    }
}
