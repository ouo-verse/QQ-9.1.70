package com.tencent.guild.aio.input.at.hashtag.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagListAdapter;
import com.tencent.guild.aio.input.at.hashtag.ui.h;
import com.tencent.guild.aio.input.at.quickAt.ui.GuildAtPanelTouchController;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class i implements GuildAtPanelTouchController.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f110954a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<InputMethodManager> f110955b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f110956c;

    /* renamed from: d, reason: collision with root package name */
    protected j f110957d;

    /* renamed from: e, reason: collision with root package name */
    protected h f110958e;

    /* renamed from: f, reason: collision with root package name */
    protected int f110959f;

    /* renamed from: g, reason: collision with root package name */
    private int f110960g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f110961h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f110962i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f110963a;

        static {
            int[] iArr = new int[HashTagViewType.values().length];
            f110963a = iArr;
            try {
                iArr[HashTagViewType.VIEW_TYPE_CHANNEL_ITEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f110963a[HashTagViewType.VIEW_TYPE_FEED_SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f110963a[HashTagViewType.VIEW_TYPE_FEED_SECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f110963a[HashTagViewType.VIEW_TYPE_GROUP_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f110963a[HashTagViewType.VIEW_TYPE_FEED_DIVIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    interface b {
        View a(Activity activity, h hVar);
    }

    public i(@NonNull Activity activity) {
        this(activity, new h());
    }

    private int f() {
        int i3;
        ListAdapter adapter = this.f110957d.c().getAdapter();
        if (adapter == null) {
            return 0;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < adapter.getCount(); i17++) {
            int i18 = a.f110963a[((GuildHashtagListAdapter.d) adapter.getView(i17, null, this.f110957d.c()).getTag()).f110900f.ordinal()];
            if (i18 != 1 && i18 != 2 && i18 != 3) {
                if (i18 != 4) {
                    if (i18 == 5) {
                        h.b bVar = this.f110958e.f110931a;
                        i16 += bVar.f110941c + bVar.f110946h;
                    }
                } else {
                    i3 = this.f110958e.f110931a.f110939a;
                }
            } else {
                i3 = this.f110958e.f110931a.f110940b;
            }
            i16 += i3;
        }
        return i16;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.ui.GuildAtPanelTouchController.a
    public boolean a(int i3) {
        if (this.f110957d.c() != null) {
            return !r0.canScrollVertically(i3);
        }
        return false;
    }

    public int b(View view, int i3) {
        int height = this.f110956c.getWindow().getDecorView().getHeight();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (iArr[1] >= (height * 3) / 4) {
            return 2;
        }
        return 1;
    }

    public int c(boolean z16, int i3, int i16) {
        if (z16) {
            return i16 - i3;
        }
        return this.f110958e.f110931a.f110943e;
    }

    public int d(boolean z16, int i3) {
        if (this.f110954a) {
            if (z16) {
                this.f110959f = Math.min(i3 - this.f110958e.f110931a.f110950l, f() + this.f110958e.f110931a.f110942d);
                if (QLog.isDevelopLevel()) {
                    QLog.d("GuildHashtagUIHelper", 4, "visualHeight: " + this.f110959f + " usableWindowHeight: " + i3);
                }
                if (i3 != -1) {
                    this.f110959f = Math.min(i3, this.f110959f);
                }
            } else {
                this.f110959f = this.f110957d.c().getHeight();
            }
        }
        return this.f110959f;
    }

    public int e(boolean z16) {
        if (this.f110954a) {
            if (z16) {
                this.f110960g = this.f110956c.getWindow().getDecorView().getHeight();
            } else {
                this.f110960g = -1;
            }
        }
        return this.f110960g;
    }

    public b g() {
        return this.f110957d;
    }

    public h h() {
        return this.f110958e;
    }

    public View i() {
        return this.f110957d.d();
    }

    @NonNull
    public Rect j(@NonNull View view) {
        view.getLocationInWindow(this.f110961h);
        int[] iArr = this.f110961h;
        int i3 = iArr[0];
        int i16 = iArr[1];
        if (AppSetting.t(view.getContext())) {
            this.f110962i.set(i3, 0, view.getWidth() + i3, i16);
        } else {
            this.f110962i.set(0, 0, view.getWidth(), i16);
        }
        return this.f110962i;
    }

    public void k() {
        InputMethodManager inputMethodManager;
        WeakReference<InputMethodManager> weakReference = this.f110955b;
        if (weakReference != null && weakReference.get() != null) {
            inputMethodManager = this.f110955b.get();
        } else {
            inputMethodManager = (InputMethodManager) this.f110956c.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            this.f110955b = new WeakReference<>(inputMethodManager);
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f110956c.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public void l(boolean z16) {
        this.f110954a = z16 | this.f110954a;
    }

    i(@NonNull Activity activity, @NonNull h hVar) {
        this.f110954a = true;
        this.f110959f = -1;
        this.f110960g = 0;
        this.f110961h = new int[2];
        this.f110962i = new Rect();
        this.f110957d = new j();
        this.f110956c = activity;
        this.f110958e = hVar;
    }
}
