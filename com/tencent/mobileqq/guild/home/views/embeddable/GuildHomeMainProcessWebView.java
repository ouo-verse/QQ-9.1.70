package com.tencent.mobileqq.guild.home.views.embeddable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes13.dex */
public class GuildHomeMainProcessWebView extends TextureView implements e {

    /* renamed from: d, reason: collision with root package name */
    private final RemoteSurfaceHolder f225587d;

    /* loaded from: classes13.dex */
    public interface a {
        void a(View view, @NonNull int[] iArr);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void a(@Nullable String str, int i3, String str2);

        void b(@Nullable String str, int[] iArr);
    }

    public GuildHomeMainProcessWebView(@NonNull Context context) {
        this(context, null);
    }

    private boolean g() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f225587d.m();
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.e
    public boolean a(int i3) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.e
    public void c(int i3, int i16, int[] iArr) {
        this.f225587d.A(i3, i16);
        iArr[0] = i3;
        iArr[1] = i16;
    }

    public void d(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner2, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_RESUME) {
                    GuildHomeMainProcessWebView.this.k();
                    return;
                }
                if (event == Lifecycle.Event.ON_PAUSE) {
                    GuildHomeMainProcessWebView.this.j();
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    GuildHomeMainProcessWebView.this.i();
                    lifecycleOwner2.getLifecycle().removeObserver(this);
                }
            }
        });
    }

    public String e() {
        String url = this.f225587d.getUrl();
        if (url == null) {
            return "";
        }
        return url;
    }

    public String f() {
        return this.f225587d.getWebPageId();
    }

    public void h(String str, Boolean bool) {
        QLog.i("QFSMainProcessWebView", 1, "[loadUrl] url\uff1a" + str);
        this.f225587d.t(str, bool.booleanValue());
    }

    public void j() {
        this.f225587d.w();
    }

    public void k() {
        this.f225587d.x();
    }

    public void setScrollListener(a aVar) {
        this.f225587d.B(aVar);
    }

    public void setStatusListener(b bVar) {
        this.f225587d.C(bVar);
    }

    public GuildHomeMainProcessWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f225587d = new RemoteSurfaceHolder(!g(), this);
    }
}
