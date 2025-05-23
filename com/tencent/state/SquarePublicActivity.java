package com.tencent.state;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareGroupFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.chatland.ChatLandFragment;
import com.tencent.state.square.detail.DetailBaseSelectFragment;
import com.tencent.state.square.detail.DetailFragmentLauncher;
import com.tencent.state.square.detail.EntranceSource;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/SquarePublicActivity;", "Lcom/tencent/state/VasBaseActivity;", "()V", "bizInterceptOnCreateFragment", "", "clazz", "Ljava/lang/Class;", "bundle", "Landroid/os/Bundle;", "doOnCreate", Constants.FILE_INSTANCE_STATE, "doOnDestroy", "", "initFragment", "pushFragment", "fragment", "Landroidx/fragment/app/Fragment;", "Companion", "Launcher", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class SquarePublicActivity extends VasBaseActivity {
    private static final String TAG = "SquarePublicActivity";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007\u00a2\u0006\u0002\u0010\u000fJ9\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/SquarePublicActivity$Launcher;", "", "()V", "start", "", "T", "Lcom/tencent/state/VasBaseFragment;", "context", "Landroid/content/Context;", "clazz", "Ljava/lang/Class;", "bundle", "Landroid/os/Bundle;", "requestCode", "", "(Landroid/content/Context;Ljava/lang/Class;Landroid/os/Bundle;Ljava/lang/Integer;)V", "launchType", "(Landroid/content/Context;ILandroid/os/Bundle;Ljava/lang/Integer;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class Launcher {
        public static final Launcher INSTANCE = new Launcher();

        Launcher() {
        }

        @JvmStatic
        public static final void start(Context context, int launchType, Bundle bundle, Integer requestCode) {
            SquareBaseKt.getSquareLog().i(SquarePublicActivity.TAG, "Launcher.start, launchType:" + launchType + ", requestCode:" + requestCode + ", bundle:" + bundle);
            if (launchType == 3) {
                DetailFragmentLauncher.INSTANCE.launch(context, bundle, requestCode);
                return;
            }
            Intent intent = new Intent(context, (Class<?>) SquarePublicActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("launch_type", launchType);
            intent.putExtras(bundle);
            if (requestCode != null) {
                SquareBaseKt.getSquareRouter().startActivityForResult(context, intent, requestCode.intValue());
            } else {
                SquareBaseKt.getSquareRouter().startActivity(context, intent);
            }
        }

        public static /* synthetic */ void start$default(Context context, int i3, Bundle bundle, Integer num, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 1;
            }
            if ((i16 & 4) != 0) {
                bundle = null;
            }
            if ((i16 & 8) != 0) {
                num = null;
            }
            start(context, i3, bundle, num);
        }

        public static /* synthetic */ void start$default(Context context, Class cls, Bundle bundle, Integer num, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                bundle = null;
            }
            if ((i3 & 8) != 0) {
                num = null;
            }
            start(context, cls, bundle, num);
        }

        @JvmStatic
        public static final <T extends VasBaseFragment> void start(Context context, Class<T> clazz, Bundle bundle, Integer requestCode) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            SquareBaseKt.getSquareLog().i(SquarePublicActivity.TAG, "Launcher.start, clazz:" + clazz + ", requestCode:" + requestCode);
            if (context != null) {
                Intent intent = new Intent(context, (Class<?>) SquarePublicActivity.class);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                if (bundle == null) {
                    bundle = new Bundle();
                }
                intent.putExtras(bundle);
                intent.putExtra("launch_type", 0);
                intent.putExtra("public_fragment_class", clazz);
                if (requestCode != null) {
                    SquareBaseKt.getSquareRouter().startActivityForResult(context, intent, requestCode.intValue());
                } else {
                    SquareBaseKt.getSquareRouter().startActivity(context, intent);
                }
            }
        }
    }

    private final void initFragment() {
        final String str;
        Fragment fragment;
        String string;
        Intent intent = getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("public_fragment_class") : null;
        if (serializableExtra != null) {
            boolean z16 = serializableExtra instanceof Class;
            Class<?> cls = (Class) (!z16 ? null : serializableExtra);
            Intent intent2 = getIntent();
            if (bizInterceptOnCreateFragment(cls, intent2 != null ? intent2.getExtras() : null)) {
                return;
            }
            if (!z16) {
                serializableExtra = null;
            }
            Class cls2 = (Class) serializableExtra;
            Object newInstance = cls2 != null ? cls2.newInstance() : null;
            pushFragment((Fragment) (newInstance instanceof Fragment ? newInstance : null));
            return;
        }
        Intent intent3 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent3, "intent");
        Bundle extras = intent3.getExtras();
        final Ref.IntRef intRef = new Ref.IntRef();
        int i3 = 0;
        intRef.element = 0;
        final Ref.LongRef longRef = new Ref.LongRef();
        long j3 = 0;
        longRef.element = 0L;
        if (extras != null) {
            try {
                String string2 = extras.getString("appId");
                if (string2 != null) {
                    i3 = Integer.parseInt(string2);
                }
            } catch (NumberFormatException e16) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, e16.toString(), null, 4, null);
            }
        }
        intRef.element = i3;
        if (extras != null && (string = extras.getString("roomId")) != null) {
            j3 = Long.parseLong(string);
        }
        longRef.element = j3;
        if (extras == null || (str = extras.getString("jump_url")) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "bundle?.getString(KEY_JUMP_URL) ?: \"\"");
        if (getIntent().getIntExtra("launch_type", 1) != 5) {
            fragment = SquareGroupFragment.Companion.newInstance$default(SquareGroupFragment.INSTANCE, null, 1, null);
        } else {
            final SimpleGroupFragment simpleGroupFragment = new SimpleGroupFragment();
            simpleGroupFragment.setViewCreatedListener(new Runnable() { // from class: com.tencent.state.SquarePublicActivity$initFragment$$inlined$apply$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    SimpleGroupFragment.this.pushFragment(new ChatLandFragment(intRef.element, Long.valueOf(longRef.element), str));
                }
            });
            Unit unit = Unit.INSTANCE;
            fragment = simpleGroupFragment;
        }
        pushFragment(fragment);
    }

    private final void pushFragment(Fragment fragment) {
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pushFragment:");
        sb5.append(fragment != null ? fragment.getClass().getSimpleName() : null);
        squareLog.i(TAG, sb5.toString());
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.pvw, fragment).commitAllowingStateLoss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle r46) {
        SquareBaseKt.getSquareLog().i(TAG, "doOnCreate");
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        window.setNavigationBarColor(-1);
        this.mNeedStatusTrans = true;
        SquareBaseKt.getSquareCommon().setImmersiveStatus(this, 0);
        boolean doOnCreate = super.doOnCreate(r46);
        setContentView(R.layout.d38);
        initFragment();
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        SquareBaseKt.getSquareLog().i(TAG, "doOnDestroy");
    }

    private final boolean bizInterceptOnCreateFragment(Class<?> clazz, final Bundle bundle) {
        String str;
        if (clazz != null) {
            if (clazz.isAssignableFrom(DetailBaseSelectFragment.class)) {
                final SimpleGroupFragment simpleGroupFragment = new SimpleGroupFragment();
                simpleGroupFragment.setViewCreatedListener(new Runnable() { // from class: com.tencent.state.SquarePublicActivity$bizInterceptOnCreateFragment$$inlined$apply$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str2;
                        DetailFragmentLauncher detailFragmentLauncher = DetailFragmentLauncher.INSTANCE;
                        SimpleGroupFragment simpleGroupFragment2 = SimpleGroupFragment.this;
                        EntranceSource covertFromScheme = EntranceSource.INSTANCE.covertFromScheme(bundle);
                        Bundle bundle2 = bundle;
                        if (bundle2 == null || (str2 = bundle2.getString(LauncherConst.KEY_OPEN_DETAIL_UIN)) == null) {
                            str2 = "";
                        }
                        Intrinsics.checkNotNullExpressionValue(str2, "bundle?.getString(Launch\u2026EY_OPEN_DETAIL_UIN) ?: \"\"");
                        DetailFragmentLauncher.launch$default(detailFragmentLauncher, simpleGroupFragment2, covertFromScheme, str2, null, bundle, 8, null);
                    }
                });
                pushFragment(simpleGroupFragment);
                return true;
            }
            if (clazz.isAssignableFrom(ChatLandFragment.class)) {
                final int i3 = bundle != null ? bundle.getInt("appId") : 0;
                final long j3 = bundle != null ? bundle.getLong("roomId") : 0L;
                if (bundle == null || (str = bundle.getString("jump_url")) == null) {
                    str = "";
                }
                final String str2 = str;
                Intrinsics.checkNotNullExpressionValue(str2, "bundle?.getString(KEY_JUMP_URL) ?: \"\"");
                final SimpleGroupFragment simpleGroupFragment2 = new SimpleGroupFragment();
                simpleGroupFragment2.setViewCreatedListener(new Runnable() { // from class: com.tencent.state.SquarePublicActivity$bizInterceptOnCreateFragment$$inlined$apply$lambda$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        SimpleGroupFragment.this.pushFragment(new ChatLandFragment(i3, Long.valueOf(j3), str2));
                    }
                });
                pushFragment(simpleGroupFragment2);
                return true;
            }
        }
        return false;
    }
}
