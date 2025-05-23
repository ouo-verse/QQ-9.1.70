package ed1;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.gamecenter.message.UinToTinyId;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends FullCache {

    /* renamed from: a, reason: collision with root package name */
    private long f396100a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Pair<String, String>> f396101b;

    /* renamed from: c, reason: collision with root package name */
    private AppInterface f396102c;

    public c(AppInterface appInterface, DBDelayManager dBDelayManager) {
        super(appInterface, dBDelayManager, UinToTinyId.class);
        this.f396100a = 0L;
        this.f396101b = new ConcurrentHashMap<>();
        this.f396102c = appInterface;
        b();
    }

    private void b() {
        try {
            this.f396101b.clear();
            this.cacheMap.clear();
            EntityManager createEntityManager = this.f396102c.getEntityManagerFactory().createEntityManager();
            List<? extends Entity> query = createEntityManager.query(UinToTinyId.class);
            createEntityManager.close();
            if (query != null) {
                a();
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    UinToTinyId uinToTinyId = (UinToTinyId) it.next();
                    this.cacheMap.put(uinToTinyId.tinyId, uinToTinyId);
                }
            }
            this.f396100a = this.f396102c.getApplication().getSharedPreferences("sp_name_tinyid_uin_mapping", 0).getLong("key_last_uin_consume_" + this.f396102c.getCurrentAccountUin(), Long.MAX_VALUE);
            if (QLog.isColorLevel()) {
                QLog.d("Q.tiny_msg.TinyIdCache", 2, "doInit size = " + this.cacheMap.size() + ", lastUinConsume = " + this.f396100a);
            }
        } catch (Exception e16) {
            QLog.d("Q.tiny_msg.TinyIdCache", 1, "doInit occur error", e16);
        }
    }

    private UinToTinyId d(String str) {
        return (UinToTinyId) findCache(str);
    }

    private String g(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        UinToTinyId d16 = d(str3);
        if (d16 != null) {
            return d16.friendUin;
        }
        UinToTinyId uinToTinyId = new UinToTinyId();
        long j3 = this.f396100a - 1;
        this.f396100a = j3;
        uinToTinyId.friendUin = String.valueOf(j3);
        uinToTinyId.tinyId = str3;
        uinToTinyId.fromTinyId = str;
        uinToTinyId.toTinyId = str2;
        addCache(uinToTinyId);
        h();
        if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.TinyIdCache", 2, "findUinWithTinyId NULL UIN = " + uinToTinyId.friendUin + ",  fromTinyId = " + str + ", toTinyId = " + str2 + ", time = " + NetConnInfoCenter.getServerTime());
        }
        return uinToTinyId.friendUin;
    }

    private void h() {
        SharedPreferences sharedPreferences = this.f396102c.getApplication().getSharedPreferences("sp_name_tinyid_uin_mapping", 0);
        String currentAccountUin = this.f396102c.getCurrentAccountUin();
        sharedPreferences.edit().putLong("key_last_uin_consume_" + currentAccountUin, this.f396100a).apply();
        if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.TinyIdCache", 2, "persistLastConsumeId lastUinConsume = " + this.f396100a);
        }
    }

    public void a() {
        this.cacheMap.clear();
        this.f396101b.clear();
    }

    public String c(String str) {
        Pair<String, String> e16 = e(str);
        if (e16 != null) {
            return (String) e16.first;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    protected void destroy() {
        a();
    }

    public Pair<String, String> e(String str) {
        Pair<String, String> pair;
        if (this.f396101b.containsKey(str)) {
            pair = this.f396101b.get(str);
        } else {
            Iterator<Entity> it = this.cacheMap.values().iterator();
            while (true) {
                if (it.hasNext()) {
                    UinToTinyId uinToTinyId = (UinToTinyId) it.next();
                    if (TextUtils.equals(uinToTinyId.friendUin, str)) {
                        Pair<String, String> pair2 = new Pair<>(uinToTinyId.fromTinyId, uinToTinyId.toTinyId);
                        this.f396101b.put(str, pair2);
                        pair = pair2;
                        break;
                    }
                } else {
                    pair = null;
                    break;
                }
            }
        }
        if (QLog.isColorLevel() && pair != null) {
            QLog.d("Q.tiny_msg.TinyIdCache", 2, "findTinyId  from cache fromTinyId = " + ((String) pair.first) + ", toTinyId = " + ((String) pair.second));
        }
        return pair;
    }

    public synchronized String f(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return g(str, str2, str + str2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    protected String getKey(Entity entity) {
        return ((UinToTinyId) entity).tinyId;
    }

    public void onDestroy() {
        destroy();
    }
}
