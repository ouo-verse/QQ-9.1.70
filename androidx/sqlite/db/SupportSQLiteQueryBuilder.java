package androidx.sqlite.db;

import java.util.regex.Pattern;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SupportSQLiteQueryBuilder {
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] mBindArgs;
    private String mSelection;
    private final String mTable;
    private boolean mDistinct = false;
    private String[] mColumns = null;
    private String mGroupBy = null;
    private String mHaving = null;
    private String mOrderBy = null;
    private String mLimit = null;

    SupportSQLiteQueryBuilder(String str) {
        this.mTable = str;
    }

    private static void appendClause(StringBuilder sb5, String str, String str2) {
        if (!isEmpty(str2)) {
            sb5.append(str);
            sb5.append(str2);
        }
    }

    private static void appendColumns(StringBuilder sb5, String[] strArr) {
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            if (i3 > 0) {
                sb5.append(", ");
            }
            sb5.append(str);
        }
        sb5.append(TokenParser.SP);
    }

    public static SupportSQLiteQueryBuilder builder(String str) {
        return new SupportSQLiteQueryBuilder(str);
    }

    private static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public SupportSQLiteQueryBuilder columns(String[] strArr) {
        this.mColumns = strArr;
        return this;
    }

    public SupportSQLiteQuery create() {
        if (isEmpty(this.mGroupBy) && !isEmpty(this.mHaving)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        StringBuilder sb5 = new StringBuilder(120);
        sb5.append("SELECT ");
        if (this.mDistinct) {
            sb5.append("DISTINCT ");
        }
        String[] strArr = this.mColumns;
        if (strArr != null && strArr.length != 0) {
            appendColumns(sb5, strArr);
        } else {
            sb5.append(" * ");
        }
        sb5.append(" FROM ");
        sb5.append(this.mTable);
        appendClause(sb5, " WHERE ", this.mSelection);
        appendClause(sb5, " GROUP BY ", this.mGroupBy);
        appendClause(sb5, " HAVING ", this.mHaving);
        appendClause(sb5, " ORDER BY ", this.mOrderBy);
        appendClause(sb5, " LIMIT ", this.mLimit);
        return new SimpleSQLiteQuery(sb5.toString(), this.mBindArgs);
    }

    public SupportSQLiteQueryBuilder distinct() {
        this.mDistinct = true;
        return this;
    }

    public SupportSQLiteQueryBuilder groupBy(String str) {
        this.mGroupBy = str;
        return this;
    }

    public SupportSQLiteQueryBuilder having(String str) {
        this.mHaving = str;
        return this;
    }

    public SupportSQLiteQueryBuilder limit(String str) {
        if (!isEmpty(str) && !sLimitPattern.matcher(str).matches()) {
            throw new IllegalArgumentException("invalid LIMIT clauses:" + str);
        }
        this.mLimit = str;
        return this;
    }

    public SupportSQLiteQueryBuilder orderBy(String str) {
        this.mOrderBy = str;
        return this;
    }

    public SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        this.mSelection = str;
        this.mBindArgs = objArr;
        return this;
    }
}
