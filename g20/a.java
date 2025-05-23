package g20;

import com.tencent.biz.qcircleshadow.lib.listener.QCircleProfileCardChangeListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends ProfileCardObserver {

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<Integer, WeakReference<QCircleProfileCardChangeListener>> f401111d = new ConcurrentHashMap<>();

    public void a() {
        ConcurrentHashMap<Integer, WeakReference<QCircleProfileCardChangeListener>> concurrentHashMap = this.f401111d;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
    protected void onSetProfileDetail(boolean z16, int i3, Card card) {
        if (z16) {
            for (Integer num : this.f401111d.keySet()) {
                if (num != null) {
                    WeakReference<QCircleProfileCardChangeListener> weakReference = this.f401111d.get(num);
                    if (weakReference != null && weakReference.get() != null) {
                        weakReference.get().updateNickName(card.strNick, card.uin);
                    } else {
                        this.f401111d.remove(num);
                    }
                }
            }
        }
    }
}
