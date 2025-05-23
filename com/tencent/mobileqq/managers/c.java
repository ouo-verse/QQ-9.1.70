package com.tencent.mobileqq.managers;

import android.database.Cursor;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.phonecontact.data.RecommendContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SecurityUtile;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements Manager {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x013d, code lost:
    
        if (r7 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0165, code lost:
    
        r10 = new com.tencent.mobileqq.persistence.qslowtable.a(r10).build(r10).getWritableDatabase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0172, code lost:
    
        r4 = r10.rawQuery("select name from sqlite_master where type=\"table\" and name like \"mr_%\"", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0176, code lost:
    
        if (r4 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x017c, code lost:
    
        if (r4.moveToNext() == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x017e, code lost:
    
        r10.execSQL(com.tencent.mobileqq.persistence.TableBuilder.dropSQLStatement(com.tencent.mobileqq.utils.SecurityUtile.encode(r4.getString(0))));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x018e, code lost:
    
        if (r4 == null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0199, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x019c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0191, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x019d, code lost:
    
        if (r4 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x019f, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01a2, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0193, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0194, code lost:
    
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0197, code lost:
    
        if (r4 == null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0162, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0160, code lost:
    
        if (r7 != null) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            return;
        }
        com.tencent.mobileqq.persistence.l c16 = com.tencent.mobileqq.persistence.l.c(str);
        SQLiteDatabase writableDatabase = c16.build(str).getWritableDatabase();
        Cursor cursor4 = null;
        try {
            cursor3 = writableDatabase.rawQuery("select name from sqlite_master where type=\"table\" and name like \"mr_%\"", null);
            if (cursor3 != null) {
                while (cursor3.moveToNext()) {
                    try {
                        String encode = SecurityUtile.encode(cursor3.getString(0));
                        if (!m0.a.a(encode)) {
                            writableDatabase.execSQL(TableBuilder.dropSQLStatement(encode));
                        }
                    } catch (Exception unused) {
                        cursor = null;
                        cursor2 = cursor;
                        if (cursor3 != null) {
                        }
                        if (cursor != null) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = null;
                        cursor2 = null;
                        cursor4 = cursor3;
                        if (cursor4 != null) {
                        }
                        if (cursor != null) {
                        }
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            }
            cursor = writableDatabase.rawQuery("select name from sqlite_master where type=\"table\" and name like \"qc_%\"", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        writableDatabase.execSQL(TableBuilder.dropSQLStatement(SecurityUtile.encode(cursor.getString(0))));
                    } catch (Exception unused2) {
                        cursor2 = null;
                        if (cursor3 != null) {
                        }
                        if (cursor != null) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        cursor2 = null;
                        cursor4 = cursor3;
                        if (cursor4 != null) {
                        }
                        if (cursor != null) {
                        }
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            }
            cursor2 = writableDatabase.rawQuery("select name from sqlite_master where type=\"table\" and name like \"DynamicMsg_%\"", null);
            if (cursor2 != null) {
                while (cursor2.moveToNext()) {
                    try {
                        writableDatabase.execSQL(TableBuilder.dropSQLStatement(SecurityUtile.encode(cursor2.getString(0))));
                    } catch (Exception unused3) {
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        cursor4 = cursor3;
                        if (cursor4 != null) {
                            cursor4.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            }
            writableDatabase.execSQL(TableBuilder.dropSQLStatement(new RecentUser().getTableName()));
            writableDatabase.execSQL(TableBuilder.dropSQLStatement(new QCallRecent().getTableName()));
            writableDatabase.execSQL(TableBuilder.dropSQLStatement(new PubAccountAssistantData().getTableName()));
            writableDatabase.execSQL(TableBuilder.dropSQLStatement(new TroopBarData().getTableName()));
            writableDatabase.execSQL(TableBuilder.dropSQLStatement(new NeedHandleUserData().getTableName()));
            writableDatabase.execSQL(TableBuilder.dropSQLStatement(new ConversationInfo().getTableName()));
            writableDatabase.execSQL(TableBuilder.dropSQLStatement(new RecommendContact().getTableName()));
            writableDatabase.execSQL(TableBuilder.dropSQLStatement(new SubAccountInfo().getTableName()));
            writableDatabase.execSQL(TableBuilder.dropSQLStatement(new SubAccountMessage().getTableName()));
            c16.close();
            ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onClearAllMsg(str);
            if (cursor3 != null) {
                cursor3.close();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception unused4) {
            cursor3 = null;
            cursor = null;
        } catch (Throwable th8) {
            th = th8;
            cursor = null;
            cursor2 = null;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
