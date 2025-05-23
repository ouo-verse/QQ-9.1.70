package com.tencent.mobileqq.qwallet.kuikly;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.data.NickNameInfo;
import com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyHbModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import i01.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0002\u0011\u0012B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJI\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyHbModule;", "Li01/e;", "", "method", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "d", "a", "GetNickNameListApi", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletKuiklyHbModule extends e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0003\u000b\f\u000fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ=\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ=\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyHbModule$GetNickNameListApi;", "", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "b", "<init>", "()V", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class GetNickNameListApi {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final GetNickNameListApi f278584a = new GetNickNameListApi();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyHbModule$GetNickNameListApi$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "groupId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "uin", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyHbModule$GetNickNameListApi$a, reason: from toString */
        /* loaded from: classes16.dex */
        public static final /* data */ class GetNickNameRequest {

            @SerializedName("groupId")
            @Nullable
            private final String groupId;

            @SerializedName("uin")
            @NotNull
            private final String uin;

            @Nullable
            /* renamed from: a, reason: from getter */
            public final String getGroupId() {
                return this.groupId;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final String getUin() {
                return this.uin;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GetNickNameRequest)) {
                    return false;
                }
                GetNickNameRequest getNickNameRequest = (GetNickNameRequest) other;
                if (Intrinsics.areEqual(this.groupId, getNickNameRequest.groupId) && Intrinsics.areEqual(this.uin, getNickNameRequest.uin)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int hashCode;
                String str = this.groupId;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                return (hashCode * 31) + this.uin.hashCode();
            }

            @NotNull
            public String toString() {
                return "GetNickNameRequest(groupId=" + this.groupId + ", uin=" + this.uin + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyHbModule$GetNickNameListApi$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "groupId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Ljava/util/List;", "b", "()Ljava/util/List;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyHbModule$GetNickNameListApi$b, reason: from toString */
        /* loaded from: classes16.dex */
        public static final /* data */ class GetNickNamesRequest {

            @SerializedName("groupId")
            @Nullable
            private final String groupId;

            @SerializedName(SquareJSConst.Params.PARAMS_UIN_LIST)
            @NotNull
            private final List<String> uinList;

            @Nullable
            /* renamed from: a, reason: from getter */
            public final String getGroupId() {
                return this.groupId;
            }

            @NotNull
            public final List<String> b() {
                return this.uinList;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GetNickNamesRequest)) {
                    return false;
                }
                GetNickNamesRequest getNickNamesRequest = (GetNickNamesRequest) other;
                if (Intrinsics.areEqual(this.groupId, getNickNamesRequest.groupId) && Intrinsics.areEqual(this.uinList, getNickNamesRequest.uinList)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int hashCode;
                String str = this.groupId;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                return (hashCode * 31) + this.uinList.hashCode();
            }

            @NotNull
            public String toString() {
                return "GetNickNamesRequest(groupId=" + this.groupId + ", uinList=" + this.uinList + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyHbModule$GetNickNameListApi$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "uin", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uid", "getUid", "nickName", "getNickName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyHbModule$GetNickNameListApi$c, reason: from toString */
        /* loaded from: classes16.dex */
        public static final /* data */ class NickNameBean {

            @SerializedName("nickName")
            @Nullable
            private final String nickName;

            @SerializedName("uid")
            @Nullable
            private final String uid;

            @SerializedName("uin")
            @NotNull
            private final String uin;

            public NickNameBean(@NotNull String uin, @Nullable String str, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(uin, "uin");
                this.uin = uin;
                this.uid = str;
                this.nickName = str2;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NickNameBean)) {
                    return false;
                }
                NickNameBean nickNameBean = (NickNameBean) other;
                if (Intrinsics.areEqual(this.uin, nickNameBean.uin) && Intrinsics.areEqual(this.uid, nickNameBean.uid) && Intrinsics.areEqual(this.nickName, nickNameBean.nickName)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2 = this.uin.hashCode() * 31;
                String str = this.uid;
                int i3 = 0;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int i16 = (hashCode2 + hashCode) * 31;
                String str2 = this.nickName;
                if (str2 != null) {
                    i3 = str2.hashCode();
                }
                return i16 + i3;
            }

            @NotNull
            public String toString() {
                return "NickNameBean(uin=" + this.uin + ", uid=" + this.uid + ", nickName=" + this.nickName + ")";
            }
        }

        GetNickNameListApi() {
        }

        public final void a(@Nullable String params, @Nullable final Function1<Object, Unit> callback) {
            final GetNickNameRequest getNickNameRequest = (GetNickNameRequest) new GsonBuilder().create().fromJson(params, GetNickNameRequest.class);
            QLog.i("QWalletHbModule", 1, "getNickName: " + getNickNameRequest);
            ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickName(getNickNameRequest.getGroupId(), getNickNameRequest.getUin(), new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyHbModule$GetNickNameListApi$getNickName$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String rsp) {
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    QWalletKuiklyHbModule.GetNickNameListApi.NickNameBean nickNameBean = new QWalletKuiklyHbModule.GetNickNameListApi.NickNameBean(QWalletKuiklyHbModule.GetNickNameListApi.GetNickNameRequest.this.getUin(), "", rsp);
                    Function1<Object, Unit> function1 = callback;
                    if (function1 != null) {
                        function1.invoke(new GsonBuilder().create().toJson(nickNameBean));
                    }
                }
            });
        }

        public final void b(@Nullable String params, @Nullable final Function1<Object, Unit> callback) {
            GetNickNamesRequest getNickNamesRequest = (GetNickNamesRequest) new GsonBuilder().create().fromJson(params, GetNickNamesRequest.class);
            QLog.i("QWalletHbModule", 1, "getNickNameList: " + getNickNamesRequest);
            ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickNameList(getNickNamesRequest.getGroupId(), getNickNamesRequest.b(), new Function1<List<? extends NickNameInfo>, Unit>() { // from class: com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyHbModule$GetNickNameListApi$getNickNameList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends NickNameInfo> list) {
                    invoke2((List<NickNameInfo>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<NickNameInfo> rsp) {
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    JSONArray jSONArray = new JSONArray();
                    for (NickNameInfo nickNameInfo : rsp) {
                        jSONArray.mo162put(new GsonBuilder().create().toJson(new QWalletKuiklyHbModule.GetNickNameListApi.NickNameBean(nickNameInfo.getUin(), nickNameInfo.getUid(), nickNameInfo.getNickName())));
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("nickNameList", jSONArray);
                    Function1<Object, Unit> function1 = callback;
                    if (function1 != null) {
                        function1.invoke(jSONObject);
                    }
                }
            });
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "getNickName")) {
            GetNickNameListApi.f278584a.a(params, callback);
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, "getNickNameList")) {
            GetNickNameListApi.f278584a.b(params, callback);
            return Unit.INSTANCE;
        }
        QLog.w("QWalletHbModule", 1, "unknown method: " + method);
        return super.call(method, params, callback);
    }
}
