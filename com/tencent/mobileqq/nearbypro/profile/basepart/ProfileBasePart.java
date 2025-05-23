package com.tencent.mobileqq.nearbypro.profile.basepart;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.nearbypro.part.e;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R#\u0010\u001e\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/basepart/ProfileBasePart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "", "f", "J", "E9", "()J", "setMTinyId", "(J)V", "mTinyId", "", h.F, "Z", "F9", "()Z", "setSelf", "(Z)V", "isSelf", "Lcom/tencent/mobileqq/nearbypro/profile/basepart/b;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/tencent/mobileqq/nearbypro/profile/basepart/b;", "profileViewModel", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class ProfileBasePart extends e {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mTinyId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isSelf;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy profileViewModel;

    public ProfileBasePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.nearbypro.profile.basepart.ProfileBasePart$profileViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return (b) ProfileBasePart.this.getViewModel(b.class);
            }
        });
        this.profileViewModel = lazy;
    }

    /* renamed from: E9, reason: from getter */
    public final long getMTinyId() {
        return this.mTinyId;
    }

    /* renamed from: F9, reason: from getter */
    public final boolean getIsSelf() {
        return this.isSelf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        boolean z16;
        this.mTinyId = A9(CommonConstant.RETKEY.USERID, 0L);
        if (s.a() == this.mTinyId) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isSelf = z16;
    }
}
