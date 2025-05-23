package com.tencent.mobileqq.guild.common.upload;

import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/common/upload/c;", "", "Lcom/tencent/mobileqq/guild/common/upload/a;", "b", "Lcom/tencent/mobileqq/guild/common/upload/a;", "guildCover", "c", "liveCover", "d", "personalAvatar", "e", "guildAvatar", "f", "guildUserAvatar", "g", "clearGuildUserAvatar", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f215496a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final UploadEndPoint guildCover = new UploadEndPoint(FlockBaseRequest.QUN_DOMAIN, "https://qun.qq.com/cgi-bin/group_pro/manage/cover_upload");

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final UploadEndPoint liveCover = new UploadEndPoint(FlockBaseRequest.QUN_DOMAIN, "https://qun.qq.com/cgi-bin/group_pro/manage/live_cover_upload");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final UploadEndPoint personalAvatar = new UploadEndPoint(FlockBaseRequest.QUN_DOMAIN, "https://qun.qq.com/cgi-bin/group_pro/manage/personal_avatar_upload");

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final UploadEndPoint guildAvatar = new UploadEndPoint(FlockBaseRequest.QUN_DOMAIN, "https://qun.qq.com/cgi-bin/group_pro/manage/avatar_upload");

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final UploadEndPoint guildUserAvatar = new UploadEndPoint(FlockBaseRequest.QUN_DOMAIN, "https://qun.qq.com/cgi-bin/group_pro/manage/guild_personal_avatar_upload");

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final UploadEndPoint clearGuildUserAvatar = new UploadEndPoint(FlockBaseRequest.QUN_DOMAIN, "https://qun.qq.com/cgi-bin/group_pro/manage/guild_personal_avatar_clear");

    c() {
    }
}
