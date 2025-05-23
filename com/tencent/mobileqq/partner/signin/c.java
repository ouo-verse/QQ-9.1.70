package com.tencent.mobileqq.partner.signin;

import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$BusSigninDetail;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$MemberSigninDetailEntity;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SigninData;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SigninDataEntity;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$BusSigninDetail;", "", "errCode", "", "markId", "Lcom/tencent/mobileqq/partner/signin/b;", "a", "mutualmark_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    @NotNull
    public static final b a(@Nullable GeneralSigninPB$BusSigninDetail generalSigninPB$BusSigninDetail, int i3, long j3) {
        String str;
        Object orNull;
        GeneralSigninPB$SigninData generalSigninPB$SigninData;
        PBInt32Field pBInt32Field;
        b bVar = new b(0, 0, 0L, null, null, 0, null, null, null, null, null, 2047, null);
        bVar.o(i3);
        if (generalSigninPB$BusSigninDetail != null) {
            Iterator<GeneralSigninPB$MemberSigninDetailEntity> it = generalSigninPB$BusSigninDetail.member_detail.get().iterator();
            while (true) {
                str = "";
                if (!it.hasNext()) {
                    break;
                }
                GeneralSigninPB$MemberSigninDetailEntity next = it.next();
                String str2 = next.key.get();
                if (str2 != null) {
                    str = str2;
                }
                List<GeneralSigninPB$SigninDataEntity> list = next.value.list.get();
                Intrinsics.checkNotNullExpressionValue(list, "detailEntity.value.list.get()");
                boolean z16 = false;
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
                GeneralSigninPB$SigninDataEntity generalSigninPB$SigninDataEntity = (GeneralSigninPB$SigninDataEntity) orNull;
                if (generalSigninPB$SigninDataEntity != null && (generalSigninPB$SigninData = generalSigninPB$SigninDataEntity.value) != null && (pBInt32Field = generalSigninPB$SigninData.status) != null && pBInt32Field.get() == 1) {
                    z16 = true;
                }
                bVar.g().add(new a(str, z16, (int) next.value.count.accumulative_signin_days.get()));
            }
            bVar.u((int) generalSigninPB$BusSigninDetail.all_count.accumulative_signin_days.get());
            String str3 = generalSigninPB$BusSigninDetail.material.background_image_url.get();
            if (str3 == null) {
                str3 = "";
            }
            bVar.m(str3);
            String str4 = generalSigninPB$BusSigninDetail.material.button_text.get();
            if (str4 == null) {
                str4 = "";
            }
            bVar.n(str4);
            String str5 = generalSigninPB$BusSigninDetail.material.background_text.get();
            if (str5 == null) {
                str5 = "";
            }
            bVar.l(str5);
            String str6 = generalSigninPB$BusSigninDetail.material.theme_color.get();
            if (str6 == null) {
                str6 = "";
            }
            bVar.t(str6);
            String str7 = generalSigninPB$BusSigninDetail.material.label_text.get();
            if (str7 != null) {
                str = str7;
            }
            bVar.p(str);
            bVar.s(generalSigninPB$BusSigninDetail.bus_info.status.get());
            String str8 = generalSigninPB$BusSigninDetail.bus_info.name.get();
            if (str8 == null) {
                str8 = "\u642d\u5b50";
            }
            bVar.r(str8);
            bVar.q(j3);
        }
        return bVar;
    }
}
