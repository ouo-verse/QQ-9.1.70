package com.tencent.mobileqq.profilesetting;

import android.util.SparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/v;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class v {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SparseArray<Integer> f261115b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Integer[][] f261116c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Integer[][] f261117d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Integer[][] f261118e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Integer[][] f261119f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Integer[][] f261120g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Integer[] f261121h;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b \b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0014\u0010 \u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0016R\u0014\u0010\"\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010#\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0016R\u0014\u0010$\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016R\u0014\u0010%\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/profilesetting/v$a;", "", "Landroid/util/SparseArray;", "", "PROFILE_DISPLAY_FIELD_CONFIG_MAP", "Landroid/util/SparseArray;", "b", "()Landroid/util/SparseArray;", "", "PROFILE_DISPLAY_FIELD_BASE_ITEMS", "[[Ljava/lang/Integer;", "a", "()[[Ljava/lang/Integer;", "PROFILE_DISPLAY_FIELD_OTHER_ITEMS", "d", "PROFILE_DISPLAY_FIELD_GAME_CENTER", "c", "PROFILE_DISPLAY_FIELD_OTHER_SPEC_DEFAULT_CLOSE_ITEMS", "[Ljava/lang/Integer;", "e", "()[Ljava/lang/Integer;", "FIELD_GAME_INFO_SWITCH", "I", "FIELD_PRIVACY_MYIDOL", "FIELD_PRIVACY_PERSONAL_NOTE", "FIELD_PRIVACY_QQ_MEMBERSHIP_AND_RANK_SWITCH", "FIELD_PRIVACY_QQ_PRIVILEGE_SWITCH", "ITEM_TYPE_BASE", "ITEM_TYPE_EMPTY", "ITEM_TYPE_GAME_CENTER", "ITEM_TYPE_OTHER", "ITEM_TYPE_OTHER_CLOSE", "ITEM_TYPE_OTHER_OPEN", "ITEM_TYPE_OTHER_WITH_SECOND_LINE", "ITEM_TYPE_TITLE", "QCIRCLE_COVER_SWITCH", "QCIRCLE_DYNAMIC_AVATAR", "REQUEST_CODE_SWITCHES", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.profilesetting.v$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Integer[][] a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return v.f261116c;
            }
            return (Integer[][]) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final SparseArray<Integer> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return v.f261115b;
            }
            return (SparseArray) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final Integer[][] c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return v.f261120g;
            }
            return (Integer[][]) iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @NotNull
        public final Integer[][] d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return v.f261117d;
            }
            return (Integer[][]) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @NotNull
        public final Integer[] e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return v.f261121h;
            }
            return (Integer[]) iPatchRedirector.redirect((short) 8, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59854);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f261115b = sparseArray;
        f261116c = new Integer[][]{new Integer[]{41611, Integer.valueOf(R.string.f1761130d)}, new Integer[]{41610, Integer.valueOf(R.string.f175792zi)}, new Integer[]{41607, Integer.valueOf(R.string.f175822zl)}, new Integer[]{Integer.valueOf(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION), Integer.valueOf(R.string.f175852zo)}, new Integer[]{41618, Integer.valueOf(R.string.f17606309)}, new Integer[]{40272, Integer.valueOf(R.string.f175842zn)}, new Integer[]{41619, Integer.valueOf(R.string.f175832zm)}, new Integer[]{41614, Integer.valueOf(R.string.f175942zx)}, new Integer[]{41613, Integer.valueOf(R.string.f175932zw)}, new Integer[]{41622, Integer.valueOf(R.string.f175882zr)}, new Integer[]{41623, Integer.valueOf(R.string.f17603306)}};
        f261117d = new Integer[][]{new Integer[]{42488, Integer.valueOf(R.string.f17600303)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_PERSONALITY_LABEL_SWITCH), Integer.valueOf(R.string.f17604307)}, new Integer[]{45161, Integer.valueOf(R.string.f1760830a)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_META_FARM_SWITCH), Integer.valueOf(R.string.f175952zy)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_QQCARD_SWITCH), Integer.valueOf(R.string.f1761030c)}, new Integer[]{45160, Integer.valueOf(R.string.f1760930b)}, new Integer[]{42425, Integer.valueOf(R.string.f175812zk)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_PRESENT_SWITCH), Integer.valueOf(R.string.f17605308)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_MINIAPP_SWITCH), Integer.valueOf(R.string.f175962zz)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_MUSICBOX_SWITCH), Integer.valueOf(R.string.f17599302)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_STICKY_NOTE_SWITCH), Integer.valueOf(R.string.f1761230e)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_EXTEND_FRIEND_SWITCH), Integer.valueOf(R.string.f175892zs)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_DRESSUP_SWITCH), Integer.valueOf(R.string.f175872zq)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_Q_CUB_SWITCH), Integer.valueOf(R.string.f1760730_)}};
        f261118e = new Integer[][]{new Integer[]{Integer.valueOf(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION), Integer.valueOf(R.string.f175852zo)}, new Integer[]{41618, Integer.valueOf(R.string.f17606309)}, new Integer[]{40272, Integer.valueOf(R.string.f175842zn)}, new Integer[]{41619, Integer.valueOf(R.string.f175832zm)}, new Integer[]{41613, Integer.valueOf(R.string.f175932zw)}, new Integer[]{41622, Integer.valueOf(R.string.f175882zr)}, new Integer[]{41623, Integer.valueOf(R.string.f17603306)}};
        f261119f = new Integer[][]{new Integer[]{Integer.valueOf(ProfileContants.FIELD_MUSICBOX_SWITCH), Integer.valueOf(R.string.f17599302)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_MINIAPP_SWITCH), Integer.valueOf(R.string.f175962zz)}, new Integer[]{45161, Integer.valueOf(R.string.f1760830a)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_META_FARM_SWITCH), Integer.valueOf(R.string.f175952zy)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_QQCARD_SWITCH), Integer.valueOf(R.string.f1761030c)}, new Integer[]{45160, Integer.valueOf(R.string.f1760930b)}, new Integer[]{42425, Integer.valueOf(R.string.f175812zk)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_PRESENT_SWITCH), Integer.valueOf(R.string.f17605308)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_STICKY_NOTE_SWITCH), Integer.valueOf(R.string.f1761230e)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_QQCIRCLE_SWITCH), Integer.valueOf(R.string.wiy)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_EXTEND_FRIEND_SWITCH), Integer.valueOf(R.string.f175892zs)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_PERSONALITY_LABEL_SWITCH), Integer.valueOf(R.string.f17604307)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_DRESSUP_SWITCH), Integer.valueOf(R.string.f175872zq)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_Q_CUB_SWITCH), Integer.valueOf(R.string.f1760730_)}};
        f261120g = new Integer[][]{new Integer[]{47196, Integer.valueOf(R.string.f175912zu)}, new Integer[]{Integer.valueOf(ProfileContants.FIELD_MUSIC_DATA_SWITCH), Integer.valueOf(R.string.f17597300)}};
        f261121h = new Integer[]{Integer.valueOf(ProfileContants.FIELD_PRESENT_SWITCH), 47196, Integer.valueOf(ProfileContants.FIELD_DRESSUP_SWITCH), Integer.valueOf(ProfileContants.FIELD_QQCARD_SWITCH), Integer.valueOf(ProfileContants.FIELD_Q_CUB_SWITCH), Integer.valueOf(ProfileContants.FIELD_META_FARM_SWITCH)};
        sparseArray.put(40313, 5);
        sparseArray.put(ProfileContants.FIELD_MUSIC_SWITCH, 4);
        sparseArray.put(ProfileContants.FIELD_PERSONALITY_LABEL_SWITCH, 3);
        sparseArray.put(ProfileContants.FIELD_PRESENT_SWITCH, 6);
        sparseArray.put(ProfileContants.FIELD_MINIAPP_SWITCH, 7);
        sparseArray.put(ProfileContants.FIELD_STICKY_NOTE_SWITCH, 8);
        sparseArray.put(ProfileContants.FIELD_QQCIRCLE_SWITCH, 9);
        sparseArray.put(ProfileContants.FIELD_LIFE_ACHIEVEMENT_SWITCH, 10);
        sparseArray.put(ProfileContants.FIELD_WEISHI_SWITCH, 11);
        sparseArray.put(42425, 13);
        sparseArray.put(47196, 14);
        sparseArray.put(ProfileContants.FIELD_DRESSUP_SWITCH, 16);
        sparseArray.put(ProfileContants.FIELD_QQCARD_SWITCH, 17);
        sparseArray.put(ProfileContants.FIELD_Q_CUB_SWITCH, 18);
        sparseArray.put(ProfileContants.FIELD_MUSIC_DATA_SWITCH, 19);
        sparseArray.put(ProfileContants.FIELD_META_FARM_SWITCH, 20);
    }
}
