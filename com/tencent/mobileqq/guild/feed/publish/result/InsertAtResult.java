package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class InsertAtResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final a f223166b;

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    public static class AtBean {

        @SerializedName("atType")
        public int atType;

        @SerializedName("nickName")
        public String nickName;

        @SerializedName("roleInfo")
        public AtRoleInfo roleInfo;

        @SerializedName("tinyId")
        public String tinyId;

        public AtBean(String str, String str2, AtRoleInfo atRoleInfo, int i3) {
            this.tinyId = str;
            this.nickName = str2;
            this.roleInfo = atRoleInfo;
            this.atType = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    private static class a {

        @SerializedName("data")
        public List<AtBean> data;

        public a(List<AtBean> list) {
            this.data = list;
        }
    }

    public InsertAtResult(List<AtBean> list) {
        this.f223166b = new a(list);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223166b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.INSERT_AT;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
