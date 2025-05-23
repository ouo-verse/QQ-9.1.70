package com.tencent.mobileqq.search.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BusinessGroupWord implements Serializable {
    public a clueWordItem;
    public b groupID;
    public List<c> hotWordItemList;
    public String keyword;
    public String title;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f283443a;

        /* renamed from: b, reason: collision with root package name */
        public String f283444b;

        public a(String str, String str2) {
            this.f283443a = str;
            this.f283444b = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public List<Long> f283445a;

        public b(List<Long> list) {
            this.f283445a = list;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f283446a;

        /* renamed from: b, reason: collision with root package name */
        public String f283447b;

        /* renamed from: c, reason: collision with root package name */
        public String f283448c;

        public c() {
        }

        public c(String str, String str2) {
            this.f283446a = str;
            this.f283447b = str2;
        }
    }

    public BusinessGroupWord() {
    }

    public BusinessGroupWord(b bVar, List<c> list, a aVar) {
        this.groupID = bVar;
        new ArrayList();
        this.hotWordItemList = list;
        this.clueWordItem = aVar;
    }
}
