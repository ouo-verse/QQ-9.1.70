package mf1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.mvvm.c;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends c<mf1.a> {
    public static ViewModelProvider.Factory D = new C10779b();
    private GPServiceObserver C;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<List<lf1.a>> f416662i;

    /* renamed from: m, reason: collision with root package name */
    private String f416663m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            super.onChannelInfoUpdated(str);
            if (QLog.isColorLevel()) {
                QLog.i("Guild.c.picker.QQGuildSelectChannelViewModel", 2, "onChannelInfoUpdated paramChannelUin: " + str + ", mGuildId: " + b.this.f416663m);
            }
            b bVar = b.this;
            bVar.O1(bVar.f416663m);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            super.onChannelListUpdated(str);
            b.this.N1(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            super.onGuildInfoUpdated(str);
            b.this.N1(str);
        }
    }

    /* compiled from: P */
    /* renamed from: mf1.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C10779b implements ViewModelProvider.Factory {
        C10779b() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new b(new mf1.a());
        }
    }

    public b(mf1.a aVar) {
        super(aVar);
        this.C = new a();
        this.f416662i = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1(String str) {
        if (TextUtils.equals(str, this.f416663m)) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.c.picker.QQGuildSelectChannelViewModel", 2, "onGuildInfoUpdated paramGuildId: " + str + ", mGuildId: " + this.f416663m);
            }
            this.f416662i.postValue(O1(this.f416663m));
        }
    }

    public List<lf1.a> O1(String str) {
        return ((mf1.a) this.mRepository).n(str);
    }

    public LiveData<List<lf1.a>> P1() {
        return this.f416662i;
    }

    public void Q1(String str) {
        this.f416663m = str;
        ((mf1.a) this.mRepository).j(this.C);
    }

    public void R1(List<Long> list) {
        ((mf1.a) this.mRepository).r(list);
    }

    public void S1(List<Integer> list) {
        ((mf1.a) this.mRepository).s(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        ((mf1.a) this.mRepository).k(this.C);
    }
}
