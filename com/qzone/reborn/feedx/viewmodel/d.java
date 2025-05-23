package com.qzone.reborn.feedx.viewmodel;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/d;", "Lcom/qzone/reborn/base/n;", "", "uin", "", "R1", "", "getLogTag", "Landroid/content/Intent;", "intent", "P1", "Q1", "M1", "", "O1", "i", "J", "getMUin", "()J", "setMUin", "(J)V", "mUin", "Landroidx/lifecycle/MutableLiveData;", "Leh/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "setMFamousUserInfoData", "(Landroidx/lifecycle/MutableLiveData;)V", "mFamousUserInfoData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class d extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<eh.a> mFamousUserInfoData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedx/viewmodel/d$b", "Lcom/qzone/reborn/base/n$a;", "Leh/a;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<eh.a> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(eh.a t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            RFWLog.d("QZoneFamousUserViewModel", RFWLog.USR, "request famous user info success");
            d.this.N1().postValue(t16);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            RFWLog.d("QZoneFamousUserViewModel", RFWLog.USR, "request famous user info fail: " + errorCode + ", " + errorMsg);
        }
    }

    private final void R1(long uin) {
        new eh.c().b(uin, new b());
    }

    public final void M1() {
        R1(this.mUin);
    }

    public MutableLiveData<eh.a> N1() {
        return this.mFamousUserInfoData;
    }

    public final void Q1() {
        M1();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFamousUserViewModel";
    }

    public final void P1(Intent intent) {
        if (intent != null) {
            long longExtra = intent.getLongExtra("qqid", 0L);
            this.mUin = longExtra;
            if (longExtra == 0) {
                this.mUin = LoginData.getInstance().getUin();
            }
        }
    }

    public final boolean O1() {
        return 88882222 == this.mUin;
    }
}
