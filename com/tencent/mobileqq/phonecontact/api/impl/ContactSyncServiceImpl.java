package com.tencent.mobileqq.phonecontact.api.impl;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.StaleDataException;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.flashchat.FlashChatItem;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.mobileqq.phonecontact.api.impl.b;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.ReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ContactSyncServiceImpl implements IContactSyncService {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_BATCH_SIZE = 500;
    private static final long DELAY_REFRESH_QQ_CONTACT = 30000;
    private static final int MSG_ADD_SYNC_ACCOUNT = 1;
    private static final int MSG_REMOVE_SYNC_ACCOUNT = 2;
    private static final String PREF_FILE_NAME = "contactsync";
    private static final String PREF_REMOVE_ACCOUNT_PREFIX = "pref_remove_account_prefix";
    private static final String TAG = "ContactSync.Manager";
    private static final Set<String> accountSetIDel;
    private static String mIsSync;
    private final String PREF_SYNC_CONTACT;
    private AppInterface app;
    private com.tencent.mobileqq.phonecontact.observer.b contactOb;
    private boolean hasIRemovedByUser;
    private boolean isSyncSwitchOpen;
    private volatile boolean isSyncing;
    private AccountManager mAccountMgr;
    private String mContactAuthority;
    private Lock mLock;
    private SharedPreferences mPref;
    private RefreshContactRunnable refreshContactRunnable;
    private volatile Account syncAccount;
    private volatile boolean waitDelAccount;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f258361a;

        a(String[] strArr) {
            this.f258361a = strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, (Object) strArr);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
            } else if (cursor.moveToNext()) {
                this.f258361a[0] = cursor.getString(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f258363a;

        b(long[] jArr) {
            this.f258363a = jArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, (Object) jArr);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
            } else if (cursor.moveToNext()) {
                this.f258363a[0] = cursor.getLong(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.phonecontact.data.d f258365a;

        c(com.tencent.mobileqq.phonecontact.data.d dVar) {
            this.f258365a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
                return;
            }
            while (cursor.moveToNext()) {
                if (cursor.getString(1).equals("vnd.android.cursor.item/name")) {
                    this.f258365a.f258471a = cursor.getString(2);
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.phonecontact.data.d f258367a;

        d(com.tencent.mobileqq.phonecontact.data.d dVar) {
            this.f258367a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
                return;
            }
            if (cursor.moveToNext()) {
                this.f258367a.f258472b = cursor.getString(0);
                this.f258367a.f258473c = cursor.getString(1);
                this.f258367a.f258474d = cursor.getInt(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f258369a;

        e(HashMap hashMap) {
            this.f258369a = hashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, (Object) hashMap);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
                return;
            }
            while (cursor.moveToNext()) {
                this.f258369a.put(com.tencent.mobileqq.phonecontact.util.d.a(cursor.getString(0)), Long.valueOf(cursor.getLong(3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f258371a;

        f(ArrayList arrayList) {
            this.f258371a = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, (Object) arrayList);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
                return;
            }
            this.f258371a.ensureCapacity(cursor.getCount());
            while (cursor.moveToNext()) {
                com.tencent.mobileqq.phonecontact.data.c cVar = new com.tencent.mobileqq.phonecontact.data.c();
                cVar.f258468a = cursor.getLong(0);
                cVar.f258469b = cursor.getString(1);
                cVar.f258470c = cursor.getInt(2);
                this.f258371a.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class g implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PhoneContact f258373a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.phonecontact.data.b f258374b;

        g(PhoneContact phoneContact, com.tencent.mobileqq.phonecontact.data.b bVar) {
            this.f258373a = phoneContact;
            this.f258374b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ContactSyncServiceImpl.this, phoneContact, bVar);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
                return;
            }
            while (cursor.moveToNext()) {
                if (cursor.getString(1).equals("vnd.android.cursor.item/name")) {
                    String string = cursor.getString(2);
                    if (TextUtils.isEmpty(string) || !string.equals(this.f258373a.name)) {
                        this.f258374b.h(this.f258373a.name, ContentUris.withAppendedId(j.f258379a, cursor.getLong(0)));
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class h implements AccountManagerCallback<Boolean> {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this);
            }
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Boolean> accountManagerFuture) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) accountManagerFuture);
            } else if (QLog.isColorLevel()) {
                QLog.d(ContactSyncServiceImpl.TAG, 2, "removeSyncAccount | is done = " + accountManagerFuture.isDone());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class i implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f258377a;

        i(String[] strArr) {
            this.f258377a = strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, (Object) strArr);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
            } else if (cursor.moveToNext()) {
                this.f258377a[0] = cursor.getString(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f258379a;

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f258380b;

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f258381c;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24349);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f258379a = ContactsContract.Data.CONTENT_URI;
            f258380b = new String[]{"_id", "mimetype", StepCounterConstants.BEACON_PARAM_KEY_DATA1};
            f258381c = new String[]{"raw_contact_id", StepCounterConstants.BEACON_PARAM_KEY_DATA1};
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class k {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f258382a;

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f258383b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24350);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f258382a = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                f258383b = new String[]{StepCounterConstants.BEACON_PARAM_KEY_DATA1, "display_name", "contact_id", "raw_contact_id"};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f258384a;

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f258385b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24352);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f258384a = new String[]{"_id", "sourceid", "contact_id"};
                f258385b = new String[]{"sync1", "sync2", "sync3"};
            }
        }

        public static final Uri a(String str) {
            return ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", str).appendQueryParameter("account_type", "com.tencent.mobileqq.account").appendQueryParameter("caller_is_syncadapter", ContactSyncServiceImpl.mIsSync).build();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24356);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            mIsSync = com.tencent.mobileqq.phonecontact.constant.a.f258440a;
            accountSetIDel = new HashSet();
        }
    }

    public ContactSyncServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.PREF_SYNC_CONTACT = "pref_sync_contact";
        this.mContactAuthority = "com.android.contacts";
        this.mLock = new ReentrantLock();
        this.isSyncing = false;
        this.contactOb = new com.tencent.mobileqq.phonecontact.observer.b() { // from class: com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this);
                }
            }

            @Override // com.tencent.mobileqq.phonecontact.observer.b
            protected void onQueryBindState(boolean z16, boolean z17, long j3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
                    return;
                }
                PhoneContactServiceImpl service = PhoneContactServiceImpl.getService(ContactSyncServiceImpl.this.app);
                int selfBindState = service.getSelfBindState();
                String currentAccountUin = ContactSyncServiceImpl.this.app.getCurrentAccountUin();
                String syncAccountUin = ContactSyncServiceImpl.this.getSyncAccountUin();
                if (QLog.isColorLevel()) {
                    QLog.d(ContactSyncServiceImpl.TAG, 2, "onQueryBindState | state = " + selfBindState + " | syncUin = " + com.tencent.mobileqq.phonecontact.util.b.b(syncAccountUin) + " | currentUin = " + com.tencent.mobileqq.phonecontact.util.b.b(currentAccountUin));
                }
                if (service.isBindContactOk()) {
                    if (TextUtils.isEmpty(syncAccountUin)) {
                        ContactSyncServiceImpl.this.runAsyncTask(1);
                        return;
                    } else {
                        if (!currentAccountUin.equals(syncAccountUin)) {
                            ContactSyncServiceImpl.this.runAsyncTask(2);
                            ContactSyncServiceImpl.this.runAsyncTask(1);
                            return;
                        }
                        return;
                    }
                }
                if (selfBindState == 5 || selfBindState == 1 || ((selfBindState == 6 && service.getSelfBindInfo() != null && service.getSelfBindInfo().lastUsedFlag == 3) || (selfBindState == 7 && service.getSelfBindInfo() != null && service.getSelfBindInfo().isStopFindMatch))) {
                    if (selfBindState == 5 || selfBindState == 1) {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    ContactSyncServiceImpl.this.markCurrentUserRebirth();
                                } else {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        }, 16, null, false);
                    }
                    if (!TextUtils.isEmpty(syncAccountUin) && syncAccountUin.equals(ContactSyncServiceImpl.this.app.getCurrentAccountUin())) {
                        ContactSyncServiceImpl.this.runAsyncTask(2);
                    }
                }
            }

            @Override // com.tencent.mobileqq.phonecontact.observer.b
            protected void onQueryContactList(boolean z16, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ContactSyncServiceImpl.TAG, 2, "onQueryContactList | isSuccess = " + z16 + " | updateFlag = " + i3);
                }
                ContactSyncServiceImpl.this.onQQContactRefreshed(4);
            }
        };
        this.refreshContactRunnable = new RefreshContactRunnable(this, null);
        this.waitDelAccount = false;
        this.syncAccount = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean addSyncAccount() {
        boolean couldAddAccount = couldAddAccount();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addSyncAccount | could add account = " + couldAddAccount);
        }
        if (!couldAddAccount) {
            return false;
        }
        this.mLock.lock();
        try {
            Account account = new Account(sqliteEscape(String.format("%s(%s)", this.app.getCurrentNickname(), this.app.getCurrentAccountUin())), "com.tencent.mobileqq.account");
            if (this.mAccountMgr.addAccountExplicitly(account, null, null)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addSyncAccount | addAcountExplicitly success");
                }
                this.syncAccount = account;
                ContentResolver.setIsSyncable(this.syncAccount, this.mContactAuthority, 1);
                ContentResolver.setSyncAutomatically(account, this.mContactAuthority, true);
                onQQContactRefreshed(2);
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addSyncAccount | addAcountExplicitly fail");
            }
        } finally {
            try {
                return true;
            } finally {
            }
        }
        return true;
    }

    private void aggregateRawContact(List<ContentProviderOperation> list, long j3, long j16) {
        if (j3 == j16) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("raw_contact_id1", Long.valueOf(j3));
        contentValues.put("raw_contact_id2", Long.valueOf(j16));
        contentValues.put("type", (Integer) 1);
        list.add(ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI).withValues(contentValues).withYieldAllowed(true).build());
    }

    private boolean applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "applyBatch | enter");
        }
        boolean z16 = false;
        try {
            this.app.getApp().getContentResolver().applyBatch(this.mContactAuthority, arrayList);
            z16 = true;
        } catch (OperationApplicationException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doSyncContacts | OperationApplicationException:", e16);
            }
        } catch (RemoteException e17) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doSyncContacts | RemoteException:", e17);
            }
        } catch (IllegalArgumentException e18) {
            String stackTraceString = Log.getStackTraceString(e18);
            if (!TextUtils.isEmpty(stackTraceString) && stackTraceString.contains("Unknown authority")) {
                onAuthorityUnknown();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doSyncContacts | IllegalArgumentException: ", e18);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "applyBatch | result = " + z16 + " | leave");
        }
        return z16;
    }

    private boolean applyBatchOn(ArrayList<ContentProviderOperation> arrayList, int i3, String str) {
        if (arrayList.size() <= i3 || shouldStopSync()) {
            return false;
        }
        boolean applyBatch = applyBatch(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("applyBatchOn | %s | res=%b size=%s", str, Boolean.valueOf(applyBatch), Integer.valueOf(arrayList.size())));
        }
        arrayList.clear();
        return applyBatch;
    }

    private boolean couldAddAccount() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "couldAddAccount | is device support = " + isSyncSupportForTheDevice() + " | app is login=" + this.app.isLogin() + " | syncContactAllowed=" + this.isSyncSwitchOpen + " | hasIRemovedByUser = " + this.hasIRemovedByUser);
        }
        if (isSyncSupportForTheDevice() && this.app.isLogin() && this.isSyncSwitchOpen && !this.hasIRemovedByUser) {
            String syncAccountUin = getSyncAccountUin();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "couldAddAccount | syncUin = " + com.tencent.mobileqq.phonecontact.util.b.b(syncAccountUin) + " | currentUin = " + com.tencent.mobileqq.phonecontact.util.b.b(this.app.getCurrentAccountUin()));
            }
            if (!TextUtils.isEmpty(syncAccountUin) && syncAccountUin.equals(this.app.getCurrentAccountUin())) {
                return false;
            }
            PhoneContactServiceImpl service = PhoneContactServiceImpl.getService(this.app);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "coundlAddAccount | pcm = " + service + " | bindState = " + service.getSelfBindState());
            }
            if (service.isBindContactOk()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "couldAddAccount | bind state = " + service.getSelfBindState());
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    private boolean couldSyncContact() {
        int i3;
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "couldSyncContact | app is login=" + this.app.isLogin() + " | syncContactAllowed=" + this.isSyncSwitchOpen);
        }
        boolean z18 = false;
        if (this.app.isLogin() && this.isSyncSwitchOpen) {
            if (com.tencent.mobileqq.phonecontact.util.e.a()) {
                return false;
            }
            String syncAccountUin = getSyncAccountUin();
            PhoneContactServiceImpl service = PhoneContactServiceImpl.getService(this.app);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("couldSyncContact | bind state = ");
            if (service != null) {
                i3 = 9;
            } else {
                i3 = FlashChatItem.ID_RANDOM;
            }
            sb5.append(i3);
            sb5.append(" | account.name = ");
            sb5.append(com.tencent.mobileqq.phonecontact.util.b.b(syncAccountUin));
            QLog.d(TAG, 1, sb5.toString());
            if (service != null && service.isBindContactOk() && this.app.getCurrentAccountUin().equals(syncAccountUin)) {
                Account account = this.syncAccount;
                if (account != null) {
                    boolean syncAutomatically = ContentResolver.getSyncAutomatically(account, this.mContactAuthority);
                    if (ContentResolver.getIsSyncable(account, this.mContactAuthority) > 0) {
                        z18 = true;
                    }
                    z17 = ContentResolver.getMasterSyncAutomatically();
                    z16 = z18;
                    z18 = syncAutomatically;
                } else {
                    z16 = false;
                    z17 = false;
                }
                QLog.d(TAG, 1, "couldSyncContact | isSystemSyncAutomatic = " + z18 + " | isSystemSyncable = " + z16 + " | isMasterSyncAutomatic = " + z17);
            }
        }
        return z18;
    }

    private void deleteRawContact(long j3, List<ContentProviderOperation> list) {
        py3.b.e(this.app.getApp().getContentResolver(), l.a(getSyncAccountName()), "_id = ?", new String[]{j3 + ""});
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteRawContact | leave");
        }
    }

    private synchronized boolean doSyncContacts(Map<String, PhoneContact> map, int i3) {
        int i16;
        boolean z16 = false;
        if (shouldStopSyncCheck(BaseConstants.BROADCAST_USERSYNC_ENTER)) {
            return false;
        }
        if (!PermissionChecker.h().f()) {
            QLog.d(TAG, 1, "doSyncContacts return. no read contacts permission !");
            return false;
        }
        List<com.tencent.mobileqq.phonecontact.data.c> rawContacts = getRawContacts();
        if (rawContacts.size() == 0) {
            return false;
        }
        QLog.d(TAG, 1, "doSyncContacts");
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet(map.size());
        HashSet hashSet2 = new HashSet();
        int size = map.size();
        Iterator<com.tencent.mobileqq.phonecontact.data.c> it = rawContacts.iterator();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i26 = 2;
            if (it.hasNext()) {
                com.tencent.mobileqq.phonecontact.data.c next = it.next();
                if (shouldStopSyncCheck("for1")) {
                    return z16;
                }
                String str = next.f258469b;
                if (!TextUtils.isEmpty(str) && map.containsKey(next.f258469b)) {
                    if (!TextUtils.isEmpty(str) && map.containsKey(str)) {
                        if (hashSet.contains(Integer.valueOf(next.f258470c))) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, "doSyncContacts | error: duplicate contact id");
                            }
                            i19++;
                            deleteRawContact(next.f258468a, arrayList);
                        } else {
                            hashSet.add(Integer.valueOf(next.f258470c));
                            if (map.get(str).contactID != next.f258470c) {
                                hashSet2.add(next.f258469b);
                                i17++;
                                updateRawContact(arrayList, map.get(str), next.f258468a);
                            }
                        }
                        map.remove(str);
                    }
                    z16 = false;
                }
                deleteRawContact(next.f258468a, arrayList);
                i18++;
                z16 = false;
            } else {
                Collection<PhoneContact> values = map.values();
                QLog.d(TAG, 1, String.format("doSyncContacts syncFrom|selfUin|syncUin|qqContactSize|rawContactSize|delCnt|delCntConflict|aggCnt|willInsertCnt|dangersDelCnt = %d|%s|%s|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(i3), this.app.getCurrentAccountUin(), com.tencent.mobileqq.phonecontact.util.b.b(getSyncAccountUin()), Integer.valueOf(size), Integer.valueOf(rawContacts.size()), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i17), Integer.valueOf(values.size()), 0));
                ReportUtil.a(this.app, i3, size, rawContacts.size(), i18, i19, 0, values.size());
                applyBatchOn(arrayList, 0, "doSyncContacts apply update ops");
                int i27 = 0;
                for (PhoneContact phoneContact : values) {
                    if (shouldStopSyncCheck("for2")) {
                        return false;
                    }
                    if (!hashSet.contains(Integer.valueOf(phoneContact.contactID))) {
                        insertRawContact(arrayList, phoneContact);
                        hashSet.add(Integer.valueOf(phoneContact.contactID));
                        hashSet2.add(phoneContact.mobileNo);
                        i27++;
                    } else if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "doSyncContacts | contact " + phoneContact.contactID + " has two match phonenum");
                    }
                    applyBatchOn(arrayList, 500, "doSyncContacts apply insert ops");
                }
                applyBatchOn(arrayList, 0, "doSyncContacts apply insert ops left");
                QLog.d(TAG, 1, String.format("doSyncContacts realInsertCnt|aggCnt = %d|%d", Integer.valueOf(i27), Integer.valueOf(hashSet2.size())));
                if (hashSet2.size() == 0) {
                    return true;
                }
                arrayList.clear();
                arrayList.ensureCapacity(hashSet2.size());
                Map<String, Long> localContacts = getLocalContacts();
                for (com.tencent.mobileqq.phonecontact.data.c cVar : rawContacts) {
                    if (hashSet2.contains(cVar.f258469b) && localContacts.containsKey(cVar.f258469b)) {
                        i16 = i26;
                        aggregateRawContact(arrayList, cVar.f258468a, localContacts.get(cVar.f258469b).longValue());
                        hashSet2.remove(cVar.f258469b);
                    } else {
                        i16 = i26;
                    }
                    applyBatchOn(arrayList, 500, "doSyncContacts apply aggregate batch");
                    i26 = i16;
                }
                int i28 = i26;
                applyBatchOn(arrayList, 0, "doSyncContacts apply aggregate batch left");
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder(1024);
                    Iterator it5 = hashSet2.iterator();
                    while (it5.hasNext()) {
                        sb5.append(com.tencent.mobileqq.phonecontact.util.b.a((String) it5.next()));
                        sb5.append("|");
                    }
                    QLog.d(TAG, i28, String.format("doSyncContacts | remain source IDs = [%s] | leave", sb5.toString()));
                }
                return true;
            }
        }
    }

    private static String extraUin(String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf("(");
            int lastIndexOf2 = str.lastIndexOf(")");
            if (lastIndexOf != -1 && lastIndexOf2 != -1) {
                return str.substring(lastIndexOf + 1, lastIndexOf2);
            }
            return null;
        }
        return null;
    }

    private Map<String, Long> getLocalContacts() {
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(k.f258382a, k.f258383b, null, null, null), new e(hashMap), false);
        return hashMap;
    }

    private Map<String, PhoneContact> getQQContacts() {
        List<PhoneContact> contactList = PhoneContactServiceImpl.getService(this.app).getContactList();
        if (contactList != null) {
            HashMap hashMap = new HashMap(contactList.size());
            for (PhoneContact phoneContact : contactList) {
                if (!TextUtils.isEmpty(phoneContact.uin)) {
                    hashMap.put(phoneContact.mobileNo, phoneContact);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getQQContacts | allList.size = " + contactList.size() + " | map.size=" + hashMap.size());
            }
            return hashMap;
        }
        return new HashMap();
    }

    private List<com.tencent.mobileqq.phonecontact.data.c> getRawContacts() {
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(l.a(getSyncAccountName()), l.f258384a, null, null, null), new f(arrayList), false);
        QLog.d(TAG, 1, "- - - read system contacts - - - getRawContacts | contact list size = " + arrayList.size());
        return arrayList;
    }

    public static ContactSyncServiceImpl getService(AppInterface appInterface) {
        if (appInterface == null) {
            return null;
        }
        return (ContactSyncServiceImpl) appInterface.getRuntimeService(IContactSyncService.class, "");
    }

    private String getSubstituteAuthority() {
        List<ProviderInfo> queryContentProviders = this.app.getApp().getPackageManager().queryContentProviders((String) null, 0, 131072);
        if (queryContentProviders != null) {
            for (ProviderInfo providerInfo : queryContentProviders) {
                if (providerInfo.authority.contains("contacts") && !providerInfo.authority.equals("com.android.contacts")) {
                    return providerInfo.authority;
                }
            }
        }
        return null;
    }

    private String getSyncAccountName() {
        Account account = this.syncAccount;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    private void initSyncAccount() {
        Account[] accountsByType = this.mAccountMgr.getAccountsByType("com.tencent.mobileqq.account");
        if (accountsByType.length > 0) {
            this.syncAccount = accountsByType[0];
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initSyncAccount | syncAccount = " + this.syncAccount);
            }
            ThreadManagerV2.executeOnNetWorkThread(new Runnable(accountsByType) { // from class: com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Account[] f258359d;

                {
                    this.f258359d = accountsByType;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, (Object) accountsByType);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ContactSyncServiceImpl.this.mLock.lock();
                    for (int i3 = 1; i3 < this.f258359d.length; i3++) {
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d(ContactSyncServiceImpl.TAG, 2, "initSyncAccount | delAccount = " + this.f258359d[i3]);
                            }
                            ContactSyncServiceImpl.this.mAccountMgr.removeAccount(this.f258359d[i3], null, null);
                        } catch (Throwable unused) {
                        }
                    }
                    ContactSyncServiceImpl.this.mLock.unlock();
                }
            });
        }
    }

    private void insertRawContact(List<ContentProviderOperation> list, PhoneContact phoneContact) {
        com.tencent.mobileqq.phonecontact.data.b e16 = com.tencent.mobileqq.phonecontact.data.b.e(this.app, list, getSyncAccountName(), phoneContact.mobileNo, phoneContact.nationCode, phoneContact.mobileCode, phoneContact.ability, phoneContact.contactID);
        e16.a(phoneContact.name);
        e16.d(phoneContact.mobileNo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markCurrentUserRebirth() {
        this.hasIRemovedByUser = false;
        this.mPref.edit().remove(PREF_REMOVE_ACCOUNT_PREFIX + this.app.getCurrentAccountUin()).apply();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "markCurrentUserRebirth");
        }
    }

    private void onAuthorityUnknown() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onAuthorityUnknown | current authority = " + this.mContactAuthority);
        }
        if (this.mContactAuthority.equals("com.android.contacts")) {
            String substituteAuthority = getSubstituteAuthority();
            if (!TextUtils.isEmpty(substituteAuthority)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onAuthorityUnknown | find substitute authority = " + substituteAuthority);
                }
                this.mContactAuthority = substituteAuthority;
                Account account = this.syncAccount;
                if (account != null) {
                    ContentResolver.setSyncAutomatically(account, this.mContactAuthority, true);
                }
                onQQContactRefreshed(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSyncAccount() {
        this.mLock.lock();
        try {
            this.syncAccount = null;
            Account[] accountsByType = this.mAccountMgr.getAccountsByType("com.tencent.mobileqq.account");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "removeSyncAccount | account.length = " + accountsByType.length);
            }
            for (Account account : accountsByType) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "removeSyncAccount | a.name = " + com.tencent.mobileqq.phonecontact.util.b.b(account.name));
                }
                Set<String> set = accountSetIDel;
                synchronized (set) {
                    set.add(account.name);
                }
                this.mAccountMgr.removeAccount(account, new h(), null);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runAsyncTask(int i3) {
        ThreadManagerV2.excute(new Runnable(i3) { // from class: com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f258358d;

            {
                this.f258358d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int i16 = this.f258358d;
                if (i16 == 1) {
                    ContactSyncServiceImpl.this.addSyncAccount();
                } else if (i16 == 2) {
                    ContactSyncServiceImpl.this.removeSyncAccount();
                }
            }
        }, 32, null, true);
    }

    private boolean shouldStopSync() {
        boolean z16;
        Account account = this.syncAccount;
        boolean z17 = false;
        if (account != null && !Thread.interrupted()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shouldStopSync | account = ");
            if (account == null) {
                z17 = true;
            }
            sb5.append(z17);
            sb5.append(" | interrupted = ");
            sb5.append(Thread.interrupted());
            QLog.d(TAG, 2, sb5.toString());
        }
        return z16;
    }

    private boolean shouldStopSyncCheck(String str) {
        if (!shouldStopSync()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("doSyncContacts | shouldStopSync = true | pos = %s", str));
        }
        return true;
    }

    @SuppressLint({"InlinedApi"})
    public static String sqliteEscape(String str) {
        if (Build.MANUFACTURER.contains("OPPO")) {
            return str.replace("'", "").replace("%", "").replace("_", "-").replace("/", "").replace("[", "").replace("]", "").replace(ContainerUtils.FIELD_DELIMITER, "");
        }
        return str;
    }

    private void updateRawContact(List<ContentProviderOperation> list, PhoneContact phoneContact, long j3) {
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(j.f258379a, j.f258380b, "raw_contact_id=?", new String[]{String.valueOf(j3)}, null), new g(phoneContact, com.tencent.mobileqq.phonecontact.data.b.i(this.app, list, j3)), false);
    }

    public boolean acquirePermissionForSamsung() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.app.getApp().getContentResolver().acquireContentProviderClient("com.android.contacts");
            if (acquireContentProviderClient != null) {
                try {
                    if (VersionUtils.isNougat()) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                    return true;
                } catch (Throwable unused) {
                    return true;
                }
            }
            return true;
        } catch (SecurityException unused2) {
            return false;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public void deleteSyncContact(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        QLog.d(TAG, 1, "deleteSyncContact | mobileNo = " + com.tencent.mobileqq.phonecontact.util.b.a(str));
        py3.b.e(this.app.getApp().getContentResolver(), l.a(getSyncAccountName()), "sourceid=?", new String[]{str});
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public String getMimeTypeByJumpUri(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) uri);
        }
        String[] strArr = {null};
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(uri, new String[]{"mimetype"}, null, null, null), new i(strArr), false);
        return strArr[0];
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public String getMobileNoByJumpUri(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) uri);
        }
        String[] strArr = {null};
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(uri, new String[]{StepCounterConstants.BEACON_PARAM_KEY_DATA1}, null, null, null), new a(strArr), false);
        return strArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getNetworkDescription(GetOnlineInfoResp getOnlineInfoResp) {
        String string;
        String string2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, (Object) getOnlineInfoResp);
        }
        if (getOnlineInfoResp == null) {
            return null;
        }
        int i3 = getOnlineInfoResp.eNetworkType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            string = "";
                            string2 = "";
                            z16 = false;
                            if (z16) {
                                return null;
                            }
                            return String.format(this.app.getApp().getApplicationContext().getResources().getString(R.string.fch), string, string2);
                        }
                        string = this.app.getApp().getApplicationContext().getString(R.string.fnr);
                        string2 = this.app.getApp().getApplicationContext().getString(R.string.f201244ua);
                    } else {
                        string = this.app.getApp().getApplicationContext().getString(R.string.fnr);
                        string2 = this.app.getApp().getApplicationContext().getString(R.string.fno);
                    }
                } else {
                    string = this.app.getApp().getApplicationContext().getString(R.string.fnr);
                    string2 = this.app.getApp().getApplicationContext().getString(R.string.fnn);
                }
            } else {
                string = this.app.getApp().getApplicationContext().getString(R.string.fnq);
                string2 = this.app.getApp().getApplicationContext().getString(R.string.fnm);
            }
        } else {
            string = this.app.getApp().getApplicationContext().getString(R.string.fnr);
            string2 = this.app.getApp().getApplicationContext().getString(R.string.fns);
        }
        z16 = true;
        if (z16) {
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public com.tencent.mobileqq.phonecontact.data.d getSimplePhoneContactByJumpUri(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.phonecontact.data.d) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uri);
        }
        long[] jArr = {-1};
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(uri, new String[]{"raw_contact_id"}, null, null, null), new b(jArr), false);
        if (jArr[0] == -1) {
            return null;
        }
        com.tencent.mobileqq.phonecontact.data.d dVar = new com.tencent.mobileqq.phonecontact.data.d();
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(j.f258379a, j.f258380b, "raw_contact_id=?", new String[]{String.valueOf(jArr[0])}, null), new c(dVar), false);
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(ContactsContract.RawContacts.CONTENT_URI, l.f258385b, "_id=?", new String[]{String.valueOf(jArr[0])}, null), new d(dVar), false);
        return dVar;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public String getStatusDescription(GetOnlineInfoResp getOnlineInfoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) getOnlineInfoResp);
        }
        if (getOnlineInfoResp == null) {
            return null;
        }
        long j3 = getOnlineInfoResp.iTermType;
        int i3 = (int) getOnlineInfoResp.dwStatus;
        if (20 == i3 || 21 != i3) {
        }
        int a16 = com.tencent.mobileqq.friend.status.b.a(i3, (int) j3);
        if (a16 == 0 || a16 == 6) {
            return null;
        }
        return getOnlineInfoResp.strTermDesc;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public String getSyncAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String syncAccountName = getSyncAccountName();
        if (!TextUtils.isEmpty(syncAccountName)) {
            return extraUin(syncAccountName);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public boolean isSyncContactAllowed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSyncSwitchOpen;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public boolean isSyncSupportForTheDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (com.tencent.mobileqq.phonecontact.util.e.a()) {
            return false;
        }
        if (Build.MANUFACTURER.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
            if (!acquirePermissionForSamsung()) {
                return false;
            }
            return true;
        }
        return !r0.toLowerCase().contains("oppo");
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public void markAccountDeleteByUser(AppInterface appInterface, Account account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appInterface, (Object) account);
            return;
        }
        Set<String> set = accountSetIDel;
        synchronized (set) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "markAccountDeleteByUser | accountSetIDel = " + set + " | name = " + account.name + " | contain = " + set.contains(account.name));
            }
            if (set.remove(account.name)) {
                return;
            }
            appInterface.getApp().getSharedPreferences(PREF_FILE_NAME, 0).edit().putBoolean(PREF_REMOVE_ACCOUNT_PREFIX + account.name, true).apply();
            ContactSyncServiceImpl service = getService(appInterface);
            String currentAccountUin = appInterface.getCurrentAccountUin();
            if (!TextUtils.isEmpty(currentAccountUin) && currentAccountUin.equals(extraUin(account.name))) {
                service.hasIRemovedByUser = true;
            }
            service.syncAccount = null;
            service.waitDelAccount = false;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ContactSyncManager onCreate");
        }
        AppInterface appInterface = (AppInterface) appRuntime;
        this.app = appInterface;
        this.mAccountMgr = AccountManager.get(appInterface.getApp());
        SharedPreferences sharedPreferences = this.app.getApp().getSharedPreferences(PREF_FILE_NAME, 0);
        this.mPref = sharedPreferences;
        this.isSyncSwitchOpen = sharedPreferences.getBoolean("pref_sync_contact", true);
        try {
            initSyncAccount();
            boolean isSyncSupportForTheDevice = isSyncSupportForTheDevice();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "ContactSyncManager oncreate | support = " + isSyncSupportForTheDevice);
            }
            if (isSyncSupportForTheDevice) {
                this.app.registObserver(this.contactOb);
            } else {
                runAsyncTask(2);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initSyncAccount e = ", th5);
            }
        }
        this.hasIRemovedByUser = this.mPref.getBoolean(PREF_REMOVE_ACCOUNT_PREFIX + this.app.getCurrentAccountUin(), false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            ThreadManager.getUIHandler().removeCallbacks(this.refreshContactRunnable);
            this.app.unRegistObserver(this.contactOb);
        }
    }

    public boolean onQQContactRefreshed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncBindContactList");
        }
        ThreadManager.getUIHandler().removeCallbacks(this.refreshContactRunnable);
        if (!this.isSyncing) {
            ThreadManagerV2.executeOnNetWorkThread(new Runnable(i3) { // from class: com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f258357d;

                {
                    this.f258357d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        ContactSyncServiceImpl.this.syncAllContacts(this.f258357d);
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d(ContactSyncServiceImpl.TAG, 2, "onQQContactRefreshed | syncAllContacts exception", th5);
                        }
                    }
                }
            });
            return true;
        }
        this.refreshContactRunnable.a(i3);
        ThreadManager.getUIHandler().postDelayed(this.refreshContactRunnable, 30000L);
        return true;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public void setSyncContactAllowed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setSyncContactAllowed | allow = " + z16);
        }
        this.isSyncSwitchOpen = z16;
        this.mPref.edit().putBoolean("pref_sync_contact", z16).commit();
        if (z16) {
            this.waitDelAccount = false;
            runAsyncTask(1);
        } else if (this.isSyncing) {
            this.waitDelAccount = true;
        } else {
            this.waitDelAccount = false;
            runAsyncTask(2);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IContactSyncService
    public boolean syncAllContacts(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncAllContacts | isSyncing = " + this.isSyncing + " syncFrom = " + i3);
        }
        if (this.isSyncing || !couldSyncContact()) {
            return false;
        }
        this.isSyncing = true;
        ThreadManager.getUIHandler().removeCallbacks(this.refreshContactRunnable);
        boolean doSyncContacts = doSyncContacts(getQQContacts(), i3);
        if (this.waitDelAccount) {
            runAsyncTask(2);
            this.waitDelAccount = false;
        }
        this.isSyncing = false;
        return doSyncContacts;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class RefreshContactRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        volatile int f258360d;

        RefreshContactRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f258360d = 0;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncServiceImpl.this);
            }
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.f258360d = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                ContactSyncServiceImpl.this.onQQContactRefreshed(this.f258360d);
            }
        }

        /* synthetic */ RefreshContactRunnable(ContactSyncServiceImpl contactSyncServiceImpl, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) contactSyncServiceImpl, (Object) anonymousClass1);
        }
    }
}
