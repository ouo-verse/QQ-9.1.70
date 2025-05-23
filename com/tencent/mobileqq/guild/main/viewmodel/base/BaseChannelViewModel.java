package com.tencent.mobileqq.guild.main.viewmodel.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.guild.base.b;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class BaseChannelViewModel extends b<wy1.a> {
    private static final String TAG = "Guild.MF.Rt.BaseChannelViewModel";
    public static ViewModelProvider.Factory sViewModelFactory = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            try {
                return cls.getConstructor(wy1.a.class).newInstance(new wy1.a());
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e16) {
                QLog.e(BaseChannelViewModel.TAG, 1, e16.getMessage(), e16);
                throw new IllegalArgumentException("SubClass must have a constructor with param <QQGuildInfoRepository>!", e16);
            }
        }
    }

    public BaseChannelViewModel(wy1.a aVar) {
        super(aVar);
    }
}
