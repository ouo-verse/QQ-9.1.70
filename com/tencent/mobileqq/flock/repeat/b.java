package com.tencent.mobileqq.flock.repeat;

import android.content.Intent;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\n\u001a\u00020\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R$\u0010'\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010*\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0013\u0010,\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b+\u0010$\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/flock/repeat/b;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/flock/repeat/FlockRepeatType;", "type", "", "W1", "Ljava/util/Date;", "time", "U1", "", "N1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_selectType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_selectEndTime", "Ljava/text/SimpleDateFormat;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/text/SimpleDateFormat;", "repeatEndTimeFormat", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "selectType", "E", "O1", "selectEndTime", UserInfo.SEX_FEMALE, "P1", "selectEndTimeContent", "G", "Ljava/util/Date;", "M1", "()Ljava/util/Date;", "setActivityStartTimeDate", "(Ljava/util/Date;)V", "activityStartTimeDate", "S1", "()Lcom/tencent/mobileqq/flock/repeat/FlockRepeatType;", "selectTypeValue", "Q1", "selectEndTimeValue", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final SimpleDateFormat repeatEndTimeFormat;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<FlockRepeatType> selectType;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Date> selectEndTime;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> selectEndTimeContent;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Date activityStartTimeDate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<FlockRepeatType> _selectType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Date> _selectEndTime;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210384a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48921);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FlockRepeatType.values().length];
            try {
                iArr[FlockRepeatType.WEEK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlockRepeatType.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f210384a = iArr;
        }
    }

    public b(@NotNull Intent intent) {
        Date date;
        FlockRepeatType flockRepeatType;
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        MutableLiveData<FlockRepeatType> mutableLiveData = new MutableLiveData<>();
        this._selectType = mutableLiveData;
        MutableLiveData<Date> mutableLiveData2 = new MutableLiveData<>();
        this._selectEndTime = mutableLiveData2;
        this.repeatEndTimeFormat = new SimpleDateFormat("MM\u6708dd\u65e5", Locale.CHINA);
        this.selectType = mutableLiveData;
        this.selectEndTime = mutableLiveData2;
        LiveData<String> map = Transformations.map(mutableLiveData2, new Function() { // from class: com.tencent.mobileqq.flock.repeat.a
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String T1;
                T1 = b.T1(b.this, (Date) obj);
                return T1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(_selectEndTime) {\n  \u2026format(it) } ?: \"\u65e0\"\n    }");
        this.selectEndTimeContent = map;
        Serializable serializableExtra = intent.getSerializableExtra("key_flock_activity_start_time");
        if (serializableExtra instanceof Date) {
            date = (Date) serializableExtra;
        } else {
            date = null;
        }
        this.activityStartTimeDate = date;
        Serializable serializableExtra2 = intent.getSerializableExtra("key_flock_repeat_type");
        if (serializableExtra2 instanceof FlockRepeatType) {
            flockRepeatType = (FlockRepeatType) serializableExtra2;
        } else {
            flockRepeatType = null;
        }
        mutableLiveData.setValue(flockRepeatType == null ? FlockRepeatType.NONE : flockRepeatType);
        Serializable serializableExtra3 = intent.getSerializableExtra("key_flock_repeat_end_time");
        mutableLiveData2.setValue(serializableExtra3 instanceof Date ? (Date) serializableExtra3 : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String T1(b this$0, Date date) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (date != null) {
            str = this$0.repeatEndTimeFormat.format(date);
        } else {
            str = null;
        }
        if (str == null) {
            return "\u65e0";
        }
        return str;
    }

    @Nullable
    public final Date M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Date) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.activityStartTimeDate;
    }

    @NotNull
    public final String N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        String str = "";
        if (S1() == FlockRepeatType.NONE) {
            return "";
        }
        String content = S1().getContent();
        Date date = this.activityStartTimeDate;
        String str2 = null;
        if (date != null) {
            int i3 = a.f210384a[S1().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    str2 = "dd\u65e5";
                }
            } else {
                str2 = "E";
            }
            if (str2 == null) {
                str2 = "";
            } else {
                str2 = new SimpleDateFormat(str2, Locale.CHINA).format(date);
            }
        }
        if (str2 != null) {
            str = str2;
        }
        String str3 = content + str;
        if (Q1() == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f199244ow);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_flock_repeat_tips_for_never_end)");
            String format = String.format(qqStr, Arrays.copyOf(new Object[]{str3}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String qqStr2 = HardCodeUtil.qqStr(R.string.f199234ov);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qq_flock_repeat_tips_for_end)");
        SimpleDateFormat simpleDateFormat = this.repeatEndTimeFormat;
        Date Q1 = Q1();
        Intrinsics.checkNotNull(Q1);
        String format2 = String.format(qqStr2, Arrays.copyOf(new Object[]{str3, simpleDateFormat.format(Q1)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    @NotNull
    public final LiveData<Date> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.selectEndTime;
    }

    @NotNull
    public final LiveData<String> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.selectEndTimeContent;
    }

    @Nullable
    public final Date Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Date) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this._selectEndTime.getValue();
    }

    @NotNull
    public final LiveData<FlockRepeatType> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.selectType;
    }

    @NotNull
    public final FlockRepeatType S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (FlockRepeatType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        FlockRepeatType value = this.selectType.getValue();
        if (value == null) {
            return FlockRepeatType.NONE;
        }
        return value;
    }

    public final void U1(@Nullable Date time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) time);
        } else {
            this._selectEndTime.setValue(time);
        }
    }

    public final void W1(@NotNull FlockRepeatType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) type);
        } else {
            Intrinsics.checkNotNullParameter(type, "type");
            this._selectType.setValue(type);
        }
    }
}
