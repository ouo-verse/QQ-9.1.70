package com.tencent.common.config.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends SQLiteOpenHelper implements d {
    static IPatchRedirector $redirector_;

    public e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, cursorFactory, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, cursorFactory, Integer.valueOf(i3));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteDatabase);
            return;
        }
        sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_configs (main_key text  NOT NULL COLLATE NOCASE,second_key text  NOT NULL COLLATE NOCASE,value String,PRIMARY KEY (main_key,second_key))");
        sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_cookie (name text PRIMARY KEY NOT NULL,cookie text NOT NULL)");
        sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_update (name text PRIMARY KEY NOT NULL,updatelog text NOT NULL)");
        sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_isp_config (key text PRIMARY KEY NOT NULL,value text)");
        sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_check_time (name text PRIMARY KEY NOT NULL,check_time INTEGER NOT NULL)");
        sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_navigator_bar (uin text PRIMARY KEY NOT NULL,entraceid INTEGER NOT NULL,entracename text NOT NULL,entraceicon text,entraceaction text,isDefault INTEGER,tabid INTEGER,qbossentraceicon text,qbosstraceinfo text,iscannotshowteenagermode INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists table_qz_unread(own_uin text, type integer, ucount integer,icontrol integer,frienduins BLOB,friendMsg text,friendsNum integer,trace_info text,existDL integer, pushMsg text,schema text,iconUrl text,showMsg text,reportValue text,countID text,cTime text,iShowLevel integer,hasShow integer,actPageAttach text, tianshuTrans BLOB,expireTime text,ext BLOB, PRIMARY KEY(own_uin,type))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QZoneConfigHelper", 2, "updating database from version " + i3 + " to " + i16);
        }
        sQLiteDatabase.execSQL("drop table if exists qz_configs");
        sQLiteDatabase.execSQL("drop table if exists qz_cookie");
        sQLiteDatabase.execSQL("drop table if exists qz_update");
        sQLiteDatabase.execSQL("drop table if exists qz_isp_config");
        sQLiteDatabase.execSQL("drop table if exists qz_check_time");
        sQLiteDatabase.execSQL("drop table if exists qz_navigator_bar");
        sQLiteDatabase.execSQL("drop table if exists table_qz_unread");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QZoneConfigHelper", 2, "updating database from version " + i3 + " to " + i16);
        }
        sQLiteDatabase.execSQL("drop table if exists qz_configs");
        sQLiteDatabase.execSQL("drop table if exists qz_cookie");
        sQLiteDatabase.execSQL("drop table if exists qz_update");
        sQLiteDatabase.execSQL("drop table if exists qz_isp_config");
        sQLiteDatabase.execSQL("drop table if exists qz_check_time");
        sQLiteDatabase.execSQL("drop table if exists qz_navigator_bar");
        sQLiteDatabase.execSQL("drop table if exists table_qz_unread");
        onCreate(sQLiteDatabase);
    }
}
