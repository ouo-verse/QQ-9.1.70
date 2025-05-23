package com.tencent.mobileqq.guild.feed.publish.result;

import com.google.gson.Gson;

/* compiled from: P */
/* loaded from: classes13.dex */
abstract class AbsResult {

    /* renamed from: a, reason: collision with root package name */
    protected Gson f223160a = new Gson();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    enum Type {
        SELECT_PHOTO(0),
        SELECT_VIDEO(1),
        CREATE_TEXT_LINK(2),
        EMOJI(3),
        EDIT_DRAFT(4),
        UPLOAD_PROGRESS(5),
        SELECT_GUILD(6),
        INSERT_AT(7),
        GUILD_INFO(8),
        REDO(9),
        FONT_STYLE(10),
        SWITCH_H5_EDITOR(13),
        THIRD_CONTENT(17);

        int value;

        Type(int i3) {
            this.value = i3;
        }
    }

    protected abstract String a();

    protected abstract Type b();

    public String c() {
        return this.f223160a.toJson(new ResultWrapper(b().value, a()));
    }
}
