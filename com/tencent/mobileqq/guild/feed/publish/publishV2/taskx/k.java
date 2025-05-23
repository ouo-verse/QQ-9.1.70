package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import android.os.Bundle;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.util.bg;
import ij1.GuildImageResult;
import ij1.GuildMediaInfo;
import ij1.GuildMediaUploadTaskInfo;
import ij1.GuildVideoResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/k;", "", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildMediaProgressState;", "state", "Lij1/m;", "a", "", "path", "mimeType", "", "isRaw", "Lcom/tencent/mobileqq/guild/data/g;", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f223157a = new k();

    k() {
    }

    @NotNull
    public final GuildMediaUploadTaskInfo a(@NotNull GuildMediaProgressState state) {
        boolean z16;
        ij1.l guildImageResult;
        String str;
        String str2;
        String str3;
        String a16;
        String str4;
        Intrinsics.checkNotNullParameter(state, "state");
        int k3 = l.k(state.getType());
        String path = state.getPath();
        String str5 = "";
        if (path == null) {
            path = "";
        }
        if (path.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        long j3 = 0;
        if (!z16) {
            try {
                j3 = new File(path).length();
            } catch (Exception unused) {
            }
        }
        long j16 = j3;
        if (k3 != 1) {
            if (k3 != 2) {
                guildImageResult = null;
            } else {
                String videoId = state.getVideoId();
                if (videoId == null) {
                    videoId = "";
                }
                String coverUrl = state.getCoverUrl();
                if (coverUrl == null) {
                    str4 = "";
                } else {
                    str4 = coverUrl;
                }
                guildImageResult = new GuildVideoResult(videoId, new GuildImageResult(str4, 0, 0, 6, null));
            }
        } else {
            String coverUrl2 = state.getCoverUrl();
            if (coverUrl2 == null) {
                str = "";
            } else {
                str = coverUrl2;
            }
            guildImageResult = new GuildImageResult(str, 0, 0, 6, null);
        }
        String taskId = state.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        int state2 = state.getState();
        String clientKey = state.getClientKey();
        if (clientKey == null) {
            clientKey = "";
        }
        String str6 = null;
        int progress = state.getProgress();
        String coverUrl3 = state.getCoverUrl();
        if (coverUrl3 == null) {
            coverUrl3 = "";
        }
        int i3 = 0;
        String str7 = null;
        GuildMediaInfo guildMediaInfo = new GuildMediaInfo(path, guildImageResult);
        int errCode = state.getErrCode();
        String errMsg = state.getErrMsg();
        if (errMsg == null) {
            str2 = "";
        } else {
            str2 = errMsg;
        }
        Bundle bundle = null;
        long j17 = 0;
        long j18 = 0;
        long uploadTaskId = state.getUploadTaskId();
        if (k3 != 1 || (a16 = bg.f223884a.a(path)) == null) {
            str3 = "";
        } else {
            str3 = a16;
        }
        yl1.i iVar = yl1.i.f450608a;
        boolean k16 = iVar.k(state.isOriginalPic());
        boolean k17 = iVar.k(state.mIsGif);
        String c16 = com.tencent.mobileqq.guild.util.i.f235563a.c(path);
        if (c16 != null) {
            str5 = c16;
        }
        return new GuildMediaUploadTaskInfo(taskId, state2, k3, clientKey, str6, progress, coverUrl3, i3, str7, 0L, guildMediaInfo, errCode, str2, bundle, j17, j18, uploadTaskId, j16, str3, k16, k17, b(path, str5, iVar.k(state.isOriginalPic())), 58256, null);
    }

    @NotNull
    public final com.tencent.mobileqq.guild.data.g b(@NotNull String path, @NotNull String mimeType, boolean isRaw) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new com.tencent.mobileqq.guild.data.g(0L, path, 0L, null, 0, 0, mimeType, 0, 0L, isRaw, 0, 0, 0L, 7608, null);
    }
}
