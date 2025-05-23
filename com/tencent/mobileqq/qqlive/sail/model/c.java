package com.tencent.mobileqq.qqlive.sail.model;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.audience.SettingInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.model.common.BasicInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt3.ae;
import rt3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0012\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0000\u00a8\u0006\r"}, d2 = {"Lqr4/b;", "", "appId", "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "c", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "definition", "Lrt3/k;", "b", "Lrt3/b;", "a", "", "d", "qq-live-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272234a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50341);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[StreamDefinition.values().length];
            try {
                iArr[StreamDefinition.SD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreamDefinition.HD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StreamDefinition.SHD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StreamDefinition.FHD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f272234a = iArr;
        }
    }

    @NotNull
    public static final rt3.b a(@NotNull qr4.b bVar, @NotNull StreamDefinition definition) {
        rt3.b bVar2;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(definition, "definition");
        int i3 = a.f272234a[definition.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        bVar2 = new rt3.b();
                        qr4.g gVar = bVar.f429377b;
                        if (gVar.f429413c) {
                            bVar2.f432263a = gVar.f429421k;
                            bVar2.f432265c = "flv";
                        } else {
                            bVar2.f432263a = gVar.f429417g;
                            bVar2.f432265c = "rtmp";
                        }
                    } else {
                        bVar2 = new rt3.b();
                        qr4.g gVar2 = bVar.f429377b;
                        if (gVar2.f429413c) {
                            bVar2.f432263a = gVar2.f429421k;
                            bVar2.f432265c = "flv";
                        } else {
                            bVar2.f432263a = gVar2.f429417g;
                            bVar2.f432265c = "rtmp";
                        }
                    }
                } else {
                    bVar2 = new rt3.b();
                    qr4.g gVar3 = bVar.f429377b;
                    if (gVar3.f429413c) {
                        bVar2.f432263a = gVar3.f429420j;
                        bVar2.f432265c = "flv";
                    } else {
                        bVar2.f432263a = gVar3.f429416f;
                        bVar2.f432265c = "rtmp";
                    }
                }
            } else {
                bVar2 = new rt3.b();
                qr4.g gVar4 = bVar.f429377b;
                if (gVar4.f429413c) {
                    bVar2.f432263a = gVar4.f429419i;
                    bVar2.f432265c = "flv";
                } else {
                    bVar2.f432263a = gVar4.f429415e;
                    bVar2.f432265c = "flv";
                }
            }
        } else {
            bVar2 = new rt3.b();
            qr4.g gVar5 = bVar.f429377b;
            if (gVar5.f429413c) {
                bVar2.f432263a = gVar5.f429418h;
                bVar2.f432265c = "flv";
            } else {
                bVar2.f432263a = gVar5.f429414d;
                bVar2.f432265c = "rtmp";
            }
        }
        return bVar2;
    }

    @NotNull
    public static final k b(@NotNull qr4.b bVar, @NotNull StreamDefinition definition) {
        String str;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(definition, "definition");
        k kVar = new k();
        kVar.f432317a = definition.getValue();
        int i3 = a.f272234a[definition.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    str = "\u84dd\u5149";
                } else {
                    str = "\u8d85\u6e05";
                }
            } else {
                str = "\u9ad8\u6e05";
            }
        } else {
            str = "\u6807\u6e05";
        }
        kVar.f432319c = str;
        kVar.f432318b = new rt3.b[]{a(bVar, definition)};
        return kVar;
    }

    @NotNull
    public static final AudienceRoomInfo c(@NotNull qr4.b bVar, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(appId, "appId");
        BasicInfo basicInfo = new BasicInfo(bVar.f429376a.f429397a, null, null, null, 14, null);
        String str = bVar.f429376a.f429399c;
        Intrinsics.checkNotNullExpressionValue(str, "room.title");
        qr4.f fVar = bVar.f429376a;
        long j3 = fVar.f429408l;
        String str2 = fVar.f429398b;
        Intrinsics.checkNotNullExpressionValue(str2, "room.coverUrl");
        SettingInfo settingInfo = new SettingInfo(str, 0, j3, str2, 0, null, 50, null);
        rt3.a aVar = new rt3.a();
        rt3.e eVar = new rt3.e();
        ae aeVar = new ae();
        aeVar.f432241a = new k[]{b(bVar, StreamDefinition.SD), b(bVar, StreamDefinition.HD), b(bVar, StreamDefinition.SHD), b(bVar, StreamDefinition.FHD)};
        Unit unit = Unit.INSTANCE;
        eVar.f432278a = new ae[]{aeVar};
        aVar.f432215i = eVar;
        qr4.f fVar2 = bVar.f429376a;
        long j16 = fVar2.f429408l;
        String str3 = fVar2.f429406j;
        Intrinsics.checkNotNullExpressionValue(str3, "room.anchorName");
        String str4 = bVar.f429376a.f429407k;
        Intrinsics.checkNotNullExpressionValue(str4, "room.anchorIcon");
        AudienceRoomInfo audienceRoomInfo = new AudienceRoomInfo(basicInfo, settingInfo, new UserInfo(j16, 0, 0L, str3, str4, 0, null, 0L, 230, null), aVar, null, null, appId, 0L, null, null, null, null, 4016, null);
        audienceRoomInfo.F(bVar.f429378c);
        return audienceRoomInfo;
    }

    @NotNull
    public static final byte[] d(@NotNull qr4.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        byte[] bArr = new byte[bVar.getSerializedSize()];
        bVar.writeTo(CodedOutputByteBufferNano.newInstance(bArr));
        return bArr;
    }
}
