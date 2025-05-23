package com.tencent.mobileqq.weather.mvvm;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.jungle.weather.proto.WeatherInfo$Weather;
import com.tencent.jungle.weather.proto.weather$Config;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0007\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR0\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010(0\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0007\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010\u000b\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/e;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "setMShowLocationImg", "(Landroidx/lifecycle/MutableLiveData;)V", "mShowLocationImg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Q1", "setMTransBg", "mTransBg", "", BdhLogUtil.LogTag.Tag_Conn, "O1", "setMSelectPos", "mSelectPos", "D", "L1", "setMCitySize", "mCitySize", "Lcom/tencent/jungle/weather/proto/WeatherInfo$Weather;", "E", "S1", "setMWeather", "mWeather", "Lcom/tencent/jungle/weather/proto/weather$Config;", UserInfo.SEX_FEMALE, "M1", "setMConfig", "mConfig", "G", "N1", "setMCurrentLocationAdCode", "mCurrentLocationAdCode", "", "H", "R1", "setMWarningCityIndexList", "mWarningCityIndexList", "<init>", "()V", "I", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> mSelectPos;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> mCitySize;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<WeatherInfo$Weather> mWeather;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<weather$Config> mConfig;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<String> mCurrentLocationAdCode;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<Integer>> mWarningCityIndexList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> mShowLocationImg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> mTransBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.mvvm.e$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32961);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mShowLocationImg = new MutableLiveData<>();
        this.mTransBg = new MutableLiveData<>();
        this.mSelectPos = new MutableLiveData<>(0);
        this.mCitySize = new MutableLiveData<>(1);
        this.mWeather = new MutableLiveData<>();
        this.mConfig = new MutableLiveData<>();
        this.mCurrentLocationAdCode = new MutableLiveData<>("");
        this.mWarningCityIndexList = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<Integer> L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mCitySize;
    }

    @NotNull
    public final MutableLiveData<weather$Config> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mConfig;
    }

    @NotNull
    public final MutableLiveData<String> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mCurrentLocationAdCode;
    }

    @NotNull
    public final MutableLiveData<Integer> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mSelectPos;
    }

    @NotNull
    public final MutableLiveData<Boolean> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mShowLocationImg;
    }

    @NotNull
    public final MutableLiveData<Boolean> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mTransBg;
    }

    @NotNull
    public final MutableLiveData<List<Integer>> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mWarningCityIndexList;
    }

    @NotNull
    public final MutableLiveData<WeatherInfo$Weather> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mWeather;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "WeatherMainTitleViewModel";
    }
}
